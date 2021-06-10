# NYTimes


NYTimes App displays the Most Popular Articles from NYTimes API. App consists of a single activity (MainActivity), which holds two fragments namely NewsFragment and NewsDetailFragment . NewsFragment contains the list of articles in a recyclerview. On clicking recyclerview item, the details will be displayed in NresDetailFragment.

This app fetches the Article list from the network using the Retrofit library and displays it on the screen. It uses  ViewModel and LiveData to hold the data and update the UI. This app also makes use of DataBinding to bind data in the xml layout file itself. A low level Dependency Injection using Dagger Hilt is incorporated to inject NewsViewModel class into NewsFragment class.
