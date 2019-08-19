package afpayments.beepdirectoryproject

import afpayments.beepStorage.BeepStorage
import afpayments.beepStorage.fileType
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("BeepStorage", BeepStorage.getNonVolatileStoragePath(fileType.logs))

        val myfile = BeepStorage.getNonVolatileStorage(fileType.logs,"test.txt")

        myfile.writeText("Today is tuesday")

    }
}
