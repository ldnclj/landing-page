# London Clojurians Landing page
A website to provide details of the London Clojurians community.

The website was developed with ClojureScript, using figwheel-main as the build tool


## Development

To get an interactive development environment run:

    clojure -A:fig:build

This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files during development:

    rm -rf target/public

To create a production build run:

    clojure -A:fig:live


## License

Copyright © 2021 London Clojurians

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
