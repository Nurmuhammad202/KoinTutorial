package uz.personal.kointutorial.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.personal.kointutorial.databinding.ActivityMainBinding
import uz.personal.kointutorial.room.model.UserLocal

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel by viewModel<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnClick.setOnClickListener {
            val user=UserLocal()
            user.surname="Jek"
            viewModel.saveUser(user)

            lifecycleScope.launch{
                Log.d(TAG, "onCreateRoom-> ${viewModel.getUser()}")
            }
        }

        viewModel.getPost()

        viewModel.postLiveData.observe(this) {
            Log.d(TAG, "onCreate: $it")
        }

    }
}