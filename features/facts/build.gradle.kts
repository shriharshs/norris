import dependencies.UnitTestDependencies.Companion.unitTest
import modules.LibraryModule
import modules.LibraryType
import modules.ModuleNames

val module = LibraryModule(rootDir, LibraryType.Android)

apply(from = module.script())

plugins {
    id(BuildPlugins.Ids.androidLibrary)
}

dependencies {

    implementation(project(ModuleNames.Logger))
    implementation(project(ModuleNames.Domain))
    implementation(project(ModuleNames.Features.Architecture))
    implementation(project(ModuleNames.Features.SharedAssets))

    implementation(Libraries.kotlinStdlib)
    implementation(Libraries.kodein)

    implementation(Libraries.coroutinesCore)
    implementation(Libraries.appCompat)

    unitTest { forEachDependency { testImplementation(it) } }
    testImplementation(project(ModuleNames.CoroutinesTestUtils))
}