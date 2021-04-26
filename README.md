# London Clojurians Landing page
A website to provide details of the London Clojurians community.

The website was developed with ClojureScript, using figwheel-main as the build tool


## Development

To get an interactive development environment run:

    clojure -M:fig:build

This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files during development:

    rm -rf target/public


## Testing
Generate a minified JavaScript file from the ClojureScript file for deployment and user acceptance testing

    clojure -M:fig:live

The ClojureScript application is compiled to the `docs/js/main.js` file.  Commit and push all changes in the `docs/` directory to the landing-page repository.

View the [landing-page repository GitHub pages](https://ldnclj.github.io/landing-page/) to test the deployed application.

## Deploy live website
Deploy a new version of the live website by copying any changed files in `docs/` directory to the root of the https://github.com/ldnclj/ldnclj.github.com repository, retaining the data structure from `docs/`

## License

Copyright © 2021 London Clojurians

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
