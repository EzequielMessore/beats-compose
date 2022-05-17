import br.com.messore.tech.beats.configureAndroidCompose
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidComposePlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.withPlugin("com.android.library") {
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}
