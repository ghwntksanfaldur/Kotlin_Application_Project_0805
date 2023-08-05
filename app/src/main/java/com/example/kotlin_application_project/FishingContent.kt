package com.example.kotlin_application_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_application_project.databinding.ActivityFishingContentBinding
import com.example.kotlin_application_project.model.PageListModel
import com.example.kotlin_application_project.model.Poster
import com.example.kotlin_application_project.recycler.PosterAdapter
import retrofit2.Callback
import retrofit2.Response

class FishingContent : AppCompatActivity() {
    lateinit var binding:ActivityFishingContentBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        val serviceKey3 = "ALRX9GpugtvHxcIO/iPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH/AKv+A1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ=="
        val resultType ="json"

        var posterlist = mutableListOf<Poster>()
        posterlist.add(Poster(1, "대회 1", "2023-08-10", "서울", ""))
        posterlist.add(Poster(2, "대회 2", "2023-08-15", "부산", ""))
        posterlist.add(Poster(2, "대회 3", "2023-08-15", "부산", ""))
        posterlist.add(Poster(2, "대회 4", "2023-08-15", "부산", ""))


        super.onCreate(savedInstanceState)
        val myadapter = PosterAdapter(posterlist)
        binding = ActivityFishingContentBinding.inflate(layoutInflater)
        binding.recyclerView.adapter = myadapter

        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

        val userListCall = networkService.getList(serviceKey3,1,100,resultType)

        Log.d("kmj", "url:" + userListCall.request().url().toString())

        //부산맛집 _ 순서2
        userListCall.enqueue(object : Callback<PageListModel> {
            //도보여행_ 순서2
//            userListCall.enqueue(object : Callback<PageListModel2> {
            //도보여행 _ 순서3
//            override fun onResponse(call: retrofit2.Call<PageListModel2>, response: Response<PageListModel2>) {
            //부산 맛집 _ 순서3
            override fun onResponse(call: retrofit2.Call<PageListModel>, response: Response<PageListModel>) {

                Log.d("lsy","실행 여부 확인. userListCall.enqueue")
                val userList = response.body()
                //도보여행 로그 _ 순서4
//                Log.d("lsy","userList data 값 : ${userList?.getWalkingKr?.item}")
                //부산맛집로그 _ 순서4
                Log.d("lsy","userList data 값 : ${userList?.getFoodKr?.item}")
                Log.d("lsy","userList data 갯수 : ${userList?.getFoodKr?.item?.size}")


                //도보여행 순서5
//                binding.recyclerView.adapter= MyAdapter(this@MainActivity,userList?.getWalkingKr?.item)

                //부산맛집 순서5
//                binding.recyclerView.adapter= MyAdapter2(this@FishingContent,userList?.getFoodKr?.item)


                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(this@FishingContent, LinearLayoutManager.VERTICAL)
                )

//                binding.pageView.text=userList?.page
//                binding.totalView.text=userList?.total
            }

            //도보여행 _순서6
//            override fun onFailure(call: retrofit2.Call<PageListModel2>, t: Throwable) {
            //부산맛집 _순서6
            override fun onFailure(call: retrofit2.Call<PageListModel>, t: Throwable) {
                Log.d("lsy","fail")
                call.cancel()
            }
        })

    }
}