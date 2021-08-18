package pl.mradziewicz.dietplus.model

import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import pl.mradziewicz.dietplus.App
import pl.mradziewicz.dietplus.R

data class FoodIndgridient(
    val id: Int,
    val name: String,
    val desc: String,
    val danger: String,
    val foodExample: String,
    private val dailyMale: String,
    private val dailyFem: String,
    private val unit: IntakeDoseUnit,
    private val imgName: String)
{
   val intake
   get() = """${"\u2642"} = $dailyMale ${unit.getName()}
             | ${"\u2640"} = $dailyFem ${unit.getName()}
   """.trimMargin()
    val drawable: Drawable?
    get(){
        val ctx = App.appContext
        ctx.resources.getIdentifier(imgName, DRAWABLE_TYPE_DEF, ctx.packageName)
        return ResourcesCompat.getDrawable(ctx.resources, id, null)
    }
    companion object{
        const val DRAWABLE_TYPE_DEF = "drawable"
    }
}
enum class IntakeDoseUnit {
    GRAM {
        override fun getName() {
            App.appContext.getString(R.string.gram)
        }
    }, MGRAM {
        override fun getName() {
            App.appContext.getString(R.string.miligram)
        }
    }, UGRAM {
        override fun getName() {
            App.appContext.getString(R.string.mikrogram)
        }
    }, UI {
        override fun getName() {
            App.appContext.getString(R.string.unifiedunit)
        }
    };


    abstract fun getName()
}