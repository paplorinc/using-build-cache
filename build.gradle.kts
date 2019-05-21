plugins {
    id("com.gradle.build-scan") version "2.3"
    id("org.gradle.guides.topical") version "0.15.5"
    id("org.gradle.guides.test-jvm-code") version "0.15.5"
    kotlin("kapt") version "1.3.11" apply false
    id("org.gradle.guides.ci.travis") version "0.15.5"
}

configure<org.gradle.guides.GuidesExtension> {
    repoPath = "gradle-guides/using-build-cache"
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
}

tasks {
    asciidoctor {
        resources(delegateClosureOf<CopySpec> {
            from("contents/css") {
                into("css")
            }
            from("contents/images") {
                into("images")
            }
        })
    }
}

configure<org.gradle.guides.ci.TravisExtension> {
    encryptedVariables.add("i3FWraTJtpFlOz2zQzxhk+W9jnGbpYeTPqyL/CnHQTlLdVxcILFJO6rYDhNNB9hgMwc7lgDwYMxkiTkBGBooahsCf3dftMgfQTyg8pvcLU6zJrRjxVAnHITsPNnqtUH8Xgr8hGKyN0ZvR5UbodHx6JcttWdkgty9P6VPYpoRPOfWoEKAb5/yGyK0TAn3QZozokFM6WsoNdZsl1u7ukJXLA7jgpQeTW2paBTFk5I9qTKANaHIzYoNDEz0ZJNr7KNa8T2i220K2+nh+N49DoU93MklPYHlr9MW7LuyY5jYnYIG/cvnXqJCuR7wBzY/3XtmPGKkpxIY7d/Ww8fMREbJ03JfnCLs9YPernErimbcwMq/saLZtV1vAaY9/ko/bdiWq3YVFCZ2S39OkFoNXFUQQCUwZrLBRkTJVhGp2+9G+OzYfBsxDJvYI1WgjRO/0qNjY+tW4CSRee8EFFMTwJtuRCGo14uQEnO7YAr0w7grz2WcZzLdRBBqQZFPPduaBsTQqbJmN3ufoG33X0SC/u669c5jDFos045bj5ofcgtXO03GqmW9gsNXUujJJ+xjW0r6AS47o55FBrtEmIxEvvlFR/1Ad+8q5FVxj7ciYIeWfr/JlQuJhUQwZ+aHAwMimyeAO5dDoJIJV5N4pyMCUAENknON+sDeT9HRHvwg/hbS2BI=")
}