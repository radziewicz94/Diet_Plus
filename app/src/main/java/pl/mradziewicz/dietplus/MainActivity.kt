package pl.mradziewicz.dietplus

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import pl.mradziewicz.dietplus.model.FoodIndgridient

class MainActivity : AppCompatActivity() {

    val ingridentArray by lazy {
        val jsonStream = assets.open("base.json")
        val size = jsonStream.available()
        val buffer = ByteArray(size)
        jsonStream.read(buffer)
        jsonStream.close()
        val jsonStringer = String(buffer, Charsets.UTF_8)
        Gson().fromJson<List<FoodIndgridient>>(jsonStringer, FOOD_ING_TYPE)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    companion object{
        private val FOOD_ING_TYPE = object : TypeToken<List<FoodIndgridient>>() {}.type
    }
}