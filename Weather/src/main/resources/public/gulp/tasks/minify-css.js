'use strict';

var gulp = require('gulp');
var cleanCss = require('gulp-clean-css');

gulp.task('minify-css', function() {
  return gulp.src('./app/css/*.css')
    .pipe(cleanCss())
    .pipe(gulp.dest('./app/css'));
});