package com.example.techstore.presentation

import android.os.Bundle
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.example.domain.model.ProductsResponseItem
import com.example.techstore.databinding.ActivityDetailBinding
import com.example.techstore.util.DataSource
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class DetailActivity : AppCompatActivity() {
    lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        ViewCompat.setTransitionName(findViewById<View>(android.R.id.content), "transitionNameA")
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        val materialTransform = MaterialContainerTransform().apply {
            addTarget(android.R.id.content)
            duration = 450
            pathMotion = MaterialArcMotion()
        }
        window.sharedElementEnterTransition = materialTransform

        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.extras?.get("product") as ProductsResponseItem

        val dataSource = intent.extras?.get("dataSource")

        binding.textViewTitle.text = product.title
        binding.textViewCategory.text = product.category
        binding.textViewDescription.text = product.description
        binding.textViewPrice.text = "${product.price}"

        if (dataSource == DataSource.Remote)
        {
            Glide.with(this).load(product.image).into(binding.imageViewProduct)
        }else
        {
            Glide.with(this).load(product.completeImage).into(binding.imageViewProduct)
        }

    }
}