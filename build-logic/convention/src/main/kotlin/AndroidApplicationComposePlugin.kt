import br.com.messore.tech.beats.configureAndroidCompose
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.withPlugin("com.android.application") {
                val extension = extensions.getByType<BaseAppModuleExtension>()
                configureAndroidCompose(extension)
            }
        }
    }
}
