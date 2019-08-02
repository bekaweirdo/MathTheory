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

class AlgebraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_algebra)
        callWebService()
    }

    fun callWebService(){
        val apiService = FetchService.create()
        val call: Call<ArrayList<FetchData>> = apiService.getData()

        call.enqueue(object: Callback<ArrayList<FetchData>>{
            override fun onFailure(call: Call<ArrayList<FetchData>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<ArrayList<FetchData>>, response: Response<ArrayList<FetchData>>) {
                if(response.isSuccessful) {
                    response.body()?.let { generateDataList(it) }

                }else{
                    Log.d("retrofit", response.errorBody().toString())
                }
            }
        }
        )
    }
    fun generateDataList(articleData: ArrayList<FetchData>){
        val recyclerView = findViewById<RecyclerView>(R.id.geometry_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val article = ArrayList<Article>()

        article.add(Article("Algebra Title","This is a description"))
        for(i: FetchData in articleData){
            article.add(Article(i.title,i.text))
        }
        recyclerView.adapter= adapter(article, this)
    }
}

