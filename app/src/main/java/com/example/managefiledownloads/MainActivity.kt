package com.example.managefiledownloads

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
//import .ketch
import androidx.core.content.ContextCompat
import com.example.managefiledownloads.ui.MainScreen
import com.example.managefiledownloads.ui.theme.ManageFileDownloadsTheme
import com.ketch.DownloadConfig
import com.ketch.Ketch
import com.ketch.NotificationConfig

class MainActivity : ComponentActivity() {
   private lateinit var ketch : Ketch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){
if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),1)
}

        }
ketch=Ketch.builder().setNotificationConfig(
    NotificationConfig(
        enabled=true,
        smallIcon=R.drawable.ic_launcher_foreground
    )
).setDownloadConfig(
    DownloadConfig(
        connectTimeOutInMs = 15000,
        readTimeOutInMs = 15000
    )
).build(this)
        setContent {
            ManageFileDownloadsTheme {
         MainScreen(ketch = ketch)
            }
        }
    }
}

