package com.example.maththeory.algebra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maththeory.R
import com.example.maththeory.adapter.adapter
import com.example.maththeory.model.Article
import com.example.maththeory.model.FetchData
import com.example.maththeory.retrofit.FetchService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlgebraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algebra)
        val recyclerView = findViewById<RecyclerView>(R.id.geometry_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)

        val article = ArrayList<Article>()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(FetchService::class.java)
        val call = service.getData()
        call.enqueue(object: Callback<FetchData> {
            override fun onFailure(call: Call<FetchData>, t: Throwable) {
                Log.d("retrofit", "Failed")
            }

            override fun onResponse(call: Call<FetchData>, response: Response<FetchData>) {
                article.add(Article(response.body()!!.title, response.body()!!.text))
            }
        })

        article.add(Article("Algebra Title","This is a description"))

        recyclerView.adapter= adapter(article, this)
    }
}
