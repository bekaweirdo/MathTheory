package com.example.maththeory.algebra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maththeory.R
import com.example.maththeory.adapter.adapter
import com.example.maththeory.model.Article

class AlgebraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algebra)
        val recyclerView = findViewById<RecyclerView>(R.id.geometry_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        val article = ArrayList<Article>()

        article.add(Article("Algebra Title","This is a description"))
        article.add(Article("Title","This is a description"))
        article.add(Article("Title","This is a description"))
        article.add(Article("Title","This is a description"))
        article.add(Article("Title","This is a description"))
        article.add(Article("Title","This is a description"))
        article.add(Article("Title","This is a description"))

        recyclerView.adapter= adapter(article, this)
    }
}
