package com.hejeon.espresso.intenttest

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.invoke
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.hejeon.espresso.R
import kotlinx.android.synthetic.main.activity_pick_image.*

class PickImageActivity : AppCompatActivity() {
    //private val REQUEST_CODE_PICK_IMAGE=100 for old process
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_image)
        pickButton.setOnClickListener {
            pickFromGallery()
        }
    }

    //old process
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(resultCode == Activity.RESULT_OK){
//            when(requestCode){
//                REQUEST_CODE_PICK_IMAGE->{
//                    data?.data?.let{ uri ->
//                        Glide.with(this)
//                            .load(uri)
//                            .into(image)
//                    }
//                }
//            }
//        }
//    }

    private fun pickFromGallery() {
        //old precess
        //startActivityForResult(Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI), REQUEST_CODE_PICK_IMAGE)

        //new api
        val req: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){ activityResult ->
            activityResult.data?.data?.let{ uri ->
                Glide.with(this)
                    .load(uri)
                    .into(image)
            }
        }

        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        req(intent)
    }
}
