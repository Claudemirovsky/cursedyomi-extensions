plugins {
    id("lib-multisrc")
}

baseVersionCode = 3

dependencies {
    api(project(":lib:megacloud-extractor"))
    api(project(":lib:streamtape-extractor"))
}
