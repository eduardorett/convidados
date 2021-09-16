package com.devedu.convidados.view

import android.content.Intent
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.devedu.convidados.R
import com.devedu.convidados.databinding.ActivityMainBinding
import com.devedu.convidados.viewmodel.AllGuestsViewModel
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.app_bar_main.view.*
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.row_guest.*


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding // pega  o xml
    private lateinit var   mAllGuestsFragment: AllGuestsFragment
    private lateinit var mViewModel: AllGuestsViewModel

    ///////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProvider(this).get(AllGuestsViewModel::class.java) //inicializa para poder usar


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        btnDeleteAll.setOnClickListener {
            apagarGeral()
        }

       binding.appBarMain.fab.setOnClickListener{
         startActivity(Intent(applicationContext, GuestFormActivity::class.java)) // faz o float button ir para a proxima activyt
       }
        //////////////////////////////


        
        val drawerLayout: DrawerLayout = binding.drawerLayout // conecta com o drawerlayout
        val navView: NavigationView = binding.navView // ???
        val navController = findNavController(R.id.nav_host_fragment_content_main) // ????
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_all, R.id.nav_presents, R.id.nav_absents
            ), drawerLayout // recebe e monta esses endereços na fragment do canto esquerdo
        )
        setupActionBarWithNavController(navController, appBarConfiguration) // atualiza os dados dos recepcitivos ids
        navView.setupWithNavController(navController)
    }

    fun apagarGeral(){

        mViewModel.allDelete()
mViewModel.load()



    }

////////////////////////////////////////////////////////////////////////
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


}