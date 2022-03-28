import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.funday.databinding.ItemMealBinding
import com.example.funday.domain.MealDomain

class MealAdapter : ListAdapter<MealDomain, MealViewHolder>(MealDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = ItemMealBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = getItem(position)
        holder.bind(meal)
    }

}