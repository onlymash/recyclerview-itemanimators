package im.mash.recyclerview.itemanimators

import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by mikepenz on 08.01.16.
 */
class ScaleYAnimator : BaseScaleAnimator<ScaleYAnimator>() {
    override fun addAnimationPrepare(holder: RecyclerView.ViewHolder) {
        holder.itemView.scaleY = 0f
    }

    override fun addAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        return ViewCompat.animate(holder.itemView).scaleY(1f).setDuration(addDuration)
    }

    override fun addAnimationCleanup(holder: RecyclerView.ViewHolder) {
        holder.itemView.scaleY = 1f
    }


    override fun removeAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        val animation = ViewCompat.animate(holder.itemView)
        return animation.setDuration(removeDuration).scaleY(0f)
    }

    override fun removeAnimationCleanup(holder: RecyclerView.ViewHolder) {
        holder.itemView.scaleY = 1f
    }

    override fun changeAnimationPrepare1(holder: RecyclerView.ViewHolder): Float {
        return holder.itemView.scaleY
    }

    override fun changeAnimationPrepare2(holder: RecyclerView.ViewHolder, prevValue: Float) {
        holder.itemView.scaleY = prevValue
    }

    override fun changeAnimationPrepare3(holder: RecyclerView.ViewHolder) {
        holder.itemView.scaleY = 0f
    }

    override fun changeOldAnimation(holder: RecyclerView.ViewHolder, changeInfo: BaseItemAnimator.ChangeInfo): ViewPropertyAnimatorCompat {
        return ViewCompat.animate(holder.itemView).setDuration(changeDuration).scaleY(0f).translationX((changeInfo.toX - changeInfo.fromX).toFloat()).translationY((changeInfo.toY - changeInfo.fromY).toFloat())

    }

    override fun changeNewAnimation(holder: RecyclerView.ViewHolder): ViewPropertyAnimatorCompat {
        return ViewCompat.animate(holder.itemView).translationX(0f).translationY(0f).setDuration(changeDuration).scaleY(1f)
    }

    override fun changeAnimationCleanup(holder: RecyclerView.ViewHolder?) {
        holder?.itemView?.scaleY = 1f
    }
}
