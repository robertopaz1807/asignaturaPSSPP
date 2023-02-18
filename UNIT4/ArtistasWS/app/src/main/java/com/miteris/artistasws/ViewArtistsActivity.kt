package com.miteris.artistasws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ViewArtistsActivity : AppCompatActivity() {

   private var listView: ListView? = null
   private var artistList: MutableList<Artist>? = null
//    private lateinit var tvPrueba: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_artists)

        //Prueba inicial carga de WS
        //creating volley string request
/*      val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.POST, EndPoints.URL_GET_ARTIST,
            { response ->
                tvPrueba = findViewById<TextView>(R.id.tvPrueba)
                val obj = JSONObject(response)
                val array = obj.getJSONArray("artists")
                tvPrueba.text = array[1].toString()
            },
            {
                fun onErrorResponse(volleyError: VolleyError) {
                    Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show()
                }
            })
       queue.add(stringRequest)*/

        listView = findViewById(R.id.listViewArtists) as ListView
        artistList = mutableListOf()
        loadArtists()
    }

    private fun loadArtists() {
        val stringRequest = StringRequest(Request.Method.GET,
            EndPoints.URL_GET_ARTIST,
            { s ->
                try {
                    val obj = JSONObject(s)
                    if (!obj.getBoolean("error")) {
                        val array = obj.getJSONArray("artists")

                        for (i in 0..array.length() - 1) {
                            val objectArtist = array.getJSONObject(i)
                            val artist = Artist(
                                objectArtist.getString("name"),
                                objectArtist.getString("expertise")
                            )
                            artistList!!.add(artist)
                            val adapter = ArtistList(this@ViewArtistsActivity, artistList!!)
                            listView!!.adapter = adapter
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_LONG).show()
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { volleyError -> Toast.makeText(applicationContext, volleyError.message, Toast.LENGTH_LONG).show() })

        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }
}