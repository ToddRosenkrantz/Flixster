# Flixster
CodePath Flixster Project
## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [X] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [X] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [ ] Implement a shared element transition when user clicks into the details of a movie (1 point).
- [X] Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [X] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [X] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [ ] Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [ ] Apply the popular ButterKnife annotation library to reduce view boilerplate. (1 point)
- [X] Add a rounded corners for the images using the Glide transformations. (1 point)

**********************************************
- [X] Modified Lanscape Detail view to be scrollable.  This allows the overview to be seen if it extends below the screen.
- [X] Changed Ratings bar to have outline of 'missing' stars and changed the draw method to prevent odd colors due to old method.
- [X] Removed Status Bar on Detail screen to enhance video playback

### App Walkthough GIF

`TODO://` Add the URL to your animated app walkthough `gif` in the image tag below, `YOUR_GIF_URL_HERE`. Make sure the gif actually renders and animates when viewing this README. (🚫 Remove this paragraph after after adding gif)

<img src="YOUR_GIF_URL_HERE" width=250><br>

### Notes

Describe any challenges encountered while building the app.
Unable to find current source that discusses Shared Element Transitition with RecyclerView

## Open-source libraries used
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
# Project 1 - Flixster

Flixster is an android app that allows a user to access an online repository of information related to films currently showing in theaters.

Submitted by: Todd Rosenkrantz

Time spent: 6 hours... so far

## User Stories

The following **required** functionality is completed:
* [X] User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

The following **optional** features are implemented:
* [X] In portrait mode, the poster image, title, and movie overview is shown.
* [X] In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.
* [X] Display a nice default placeholder graphic for each image during loading
* [X] Improve the user interface through styling and coloring
      Applied dark theme elements and adjusted padding
* [ ] For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed.
      Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews
      and use different ViewHolder layout files for popular movies and less popular ones
      
The following **additional** features are implemented:

* [X] Added rating with colors to indicate "hotness"
* [X] Modified code and build files to prevent uploading API keys to github.

The following **additional improvments** for future updates:
* [ ] Use a scrollview and controls to eliminate the toolbar on scroll.
* [ ] Implement latest method to create AppIcon for current OS versions.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='Flixster_1.gif' title='Video Walkthrough' alt='Video Walkthrough' />

## Notes

Issues:
    No significant issues encountered.
    
## License

    Copyright [2020] [Todd Rosenkrantz]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
