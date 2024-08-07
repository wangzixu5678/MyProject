package com.duodian.myapplication

import android.app.Activity
import android.app.Application
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RemoteViews
import androidx.core.content.ContextCompat.getSystemService
import com.blankj.utilcode.util.ActivityUtils

/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.new_app_widget)
    views.setImageViewBitmap(R.id.widget_image,getBitmap(context))
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}


fun getBitmap(context: Context):Bitmap{
    val rootView = LayoutInflater.from(context).inflate(R.layout.test_view, null, false)
    //测量
    val manager = getSystemService(context,WindowManager::class.java) as WindowManager
    val metrics = DisplayMetrics()
    manager.defaultDisplay.getMetrics(metrics)
    val width = metrics.widthPixels
    val height = metrics.heightPixels
    val measureWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.AT_MOST)
    val measureHeight = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.AT_MOST)
    rootView.measure(measureWidth,measureHeight)
    //布局
    rootView.layout(0,0,rootView.measuredWidth,rootView.measuredHeight)
    //绘制成bitmap展示
    val bitmap = Bitmap.createBitmap(rootView.width, rootView.height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    canvas.drawColor(Color.WHITE)
    rootView.draw(canvas)
    return bitmap
}