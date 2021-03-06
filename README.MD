ReadMoreTextView
===========
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.kozemirov/readmoretextview/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.kozemirov/readmoretextview)

Straighforward Android UI lib implemented ReadMore/ShowLess TextView


![small_video](https://user-images.githubusercontent.com/7889909/174017753-af99dc9f-c766-4936-b2b3-77b743845236.gif)


Dependency
--------

```groovy
implementation 'io.github.kozemirov:readmoretextview:latest.release.here'
```

Usage
--------

```xml

<io.github.kozemirov.readmoretextview.ReadMoreTextView
        android:id="@+id/readMoreTextView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:text="Lorem ipsum"
        app:color="@color/black"
        app:textSize="12"
        app:justificationMode="1"
        app:readMoreText="Read More"
        app:showLessText="Show Less"
        app:limit="5"
        app:hidden="true"
/>
```

License
-------

```
MIT License

Copyright (c) 2022 Pavel Kozemirov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
