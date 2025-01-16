package app.grapheneos.gmscompat

import android.app.compat.gms.GmsCompat
import android.content.Intent
import android.util.Log
import android.ext.PackageId
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity

const val USAGE_GUIDE_URL = "https://grapheneos.org/usage#sandboxed-google-play"

class MainActivity : CollapsingToolbarBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        if (!GmsCompat.isEnabledFor(PackageId.GMS_CORE_NAME, userId)) {
            Log.e("GmsCompat/MainActivity", "GmsCompat is not enabled for " + PackageId.GMS_CORE_NAME);
	    val uri = Uri.parse(USAGE_GUIDE_URL)
            startActivity(Intent(Intent.ACTION_VIEW, uri))
            finishAndRemoveTask()
            return
        }
    }
}
