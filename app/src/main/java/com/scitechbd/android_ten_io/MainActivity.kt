package com.scitechbd.android_ten_io

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {
    private lateinit var tvReadFile: TextView
    private lateinit var tvFilesName: TextView
    private lateinit var tvWriteFile: TextView
    private lateinit var ivWriteFile: ImageView
    private lateinit var ivReadFile: ImageView
    private lateinit var btnWriteFile: Button
    private lateinit var btnReadFile: Button
    private lateinit var btnReadAllFiles: Button
    private lateinit var btnDeleteAllFiles: Button
    private lateinit var etFileName: EditText
    private lateinit var directory: File


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        // todo: add private mode in shared pref and merge code in Files class in mukher kotha project
        tryWithErrorDialog(this, "getting file directory got error") {
            //todo: make the directory publicly accessible
            directory = getDir("imageDir", MODE_PRIVATE)
        }

        // write file in private directory
        btnWriteFile.setOnClickListener {
            val bitmap: Bitmap = ivWriteFile.drawable.current.toBitmap()
            val fileName =
                if (etFileName.text.isNullOrEmpty()) "mukherkotha${System.currentTimeMillis()}" else etFileName.text
            val filePath = saveToInternalStorage(bitmap, fileName)
            logThis("saved image into path $filePath")
        }

        // view an image from private directory
        btnReadFile.setOnClickListener {
            if (PermissionHandler.checkPermissionForReadExternalStorageBool(this)) {
                showSnackMsg(this, "external read storage accepted")
            } else PermissionHandler.requestPermissionForReadExternalStorage(this)

            tryWithErrorDialog(this, "reading file error!") {
                loadImageFromStorage(directory.path, etFileName.text)
            }
        }

        // show all files from a directory
        btnReadAllFiles.setOnClickListener {
            tvFilesName.text = readAllFilesFromDirectory().trim()
        }

        // delete all files from a directory
        btnDeleteAllFiles.setOnClickListener {
            tvFilesName.text = deleteAllFilesFromDirectory().trim()
        }
    }

    private fun initView() {
        tvFilesName = findViewById(R.id.tvFilesName)
        tvReadFile = findViewById(R.id.tvReadFileName)
        tvWriteFile = findViewById(R.id.tvSourceFileName)
        ivWriteFile = findViewById(R.id.ivWrite)
        ivReadFile = findViewById(R.id.ivRead)
        btnReadAllFiles = findViewById(R.id.btnReadAllFiles)
        btnDeleteAllFiles = findViewById(R.id.btnDeleteAllFiles)
        btnWriteFile = findViewById(R.id.btnWriteFile)
        btnReadFile = findViewById(R.id.btnReadFile)
        etFileName = findViewById(R.id.etInputFileName)
    }

    private fun saveToInternalStorage(bitmapImage: Bitmap, fileName: CharSequence): String? {
        val myPath = File(directory, "$fileName.png")
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(myPath)
            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fos?.close()
        }
        return directory.absolutePath
    }

    private fun readAllFilesFromDirectory(): String {
        var filesListString = ""
        val mFiles = directory.listFiles()
        logThis("Files Size: ${mFiles?.size}")
        if (mFiles != null)
            for (i in mFiles.indices) {
                filesListString += "\n${mFiles[i].name}"
                logThis("FileName: ${mFiles[i].name}")
            }
        return filesListString
    }

    private fun deleteAllFilesFromDirectory(): String {
        var filesListString = ""
        val mFiles = directory.listFiles()
        logThis("Files Size: ${mFiles?.size}")
        if (mFiles != null) {
            filesListString = "total files deleted ${mFiles.size}"
            for (i in mFiles.indices) {
                filesListString += "\n${mFiles[i].name}"
                logThis("deleting FileName: ${mFiles[i].name}")
                mFiles[i].delete()
            }
        }
        return filesListString
    }

    private fun loadImageFromStorage(path: String, fileName: CharSequence) {
        val f = File(path, "$fileName.png")
        val b = BitmapFactory.decodeStream(FileInputStream(f))
        ivReadFile.setImageBitmap(b)
    }


    fun getAlbumStorageDir(): File {
        // Get the directory for the app's private pictures directory.
        val file = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "sk_read_test")
        if (!file.mkdirs()) {
            logThis("Directory not created")
        } else logThis("Directory created sk_read_test")
        logThis("getAlbumStorageDir", "file name:${file.name}")
        logThis("getAlbumStorageDir", "file path:${file.absolutePath}")
        logThis("getAlbumStorageDir", "file totalSpace:${file.totalSpace}")
        return file
    }
}