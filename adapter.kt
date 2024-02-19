import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.example.triptracker.R

class CustomAdapter(
    context:Context ,
    private val stops: List<String>,
    private val images: List<Int>
) : ArrayAdapter<String>(context, R.layout.item_structure, stops) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.item_structure, parent, false)


        val imageView: ImageView = view.findViewById(R.id.imageView)


        imageView.setImageResource(images[position])

        return view
    }
}