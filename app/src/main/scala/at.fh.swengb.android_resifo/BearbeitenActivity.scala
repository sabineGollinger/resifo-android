package at.fh.swengb.android_resifo

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.{AdapterView, EditText, ListView}

/**
  * Created by Martin on 15.01.2017.
  */
class BearbeitenActivity extends Activity{
  var db: Db = _

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    db = Db(getApplicationContext())

    var data = new Data();
    val list = data.getDataIntoList(db);


    println(list)


    setContentView(R.layout.bearbeiten)
  }

  def onItemClick(listview: ListView, view: View, i: Int, l: Long): Unit ={
    val selectedId: Int = i + 1
    val intent: Intent = new Intent(view.getContext, classOf[OverviewActivity])
    intent.putExtra("person_id", selectedId)
    startActivity(intent)
  }


}
