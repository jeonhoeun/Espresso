package com.hejeon.espresso.cameraintent

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.hejeon.espresso.R
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {
    //private val REQ_IMGCAPTURE=100 //for oldway
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        takePicture.setOnClickListener {
            //old way
            //startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), REQ_IMGCAPTURE)


            //new way
            val activityResultLauncher : ActivityResultLauncher<Intent> = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ){ activityResult->
                activityResult.data?.extras.let{extras->
                    if(extras==null || !extras.containsKey("data")){
                        return@let
                    }
                    val bitmap = extras["data"] as Bitmap?
                    imageView.setImageBitmap(bitmap)
                }
            }
            activityResultLauncher.launch( Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }
}
