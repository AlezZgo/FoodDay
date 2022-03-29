import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.funday.R
import com.example.funday.databinding.ItemMealBinding
import com.example.funday.domain.MealDomain

class MealViewHolder(
    private val binding: ItemMealBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        meal: MealDomain,
    ) = with(binding) {

        mealName.text = meal.name

        Glide.with(binding.root)
            .load(meal.imageUrl)
            .error(com.google.android.material.R.drawable.mtrl_ic_error)
            .placeholder(CircularProgressDrawable(mealImage.context))
            .override(300, 300)
            .into(binding.mealImage)

    }

}