'use strict';

var gulp = require('gulp');
var sass = require('gulp-sass');
var concat = require('gulp-concat');
var minifyCss = require('gulp-minify-css');
var rename = require('gulp-rename');

gulp.task('weather', function() {
  return gulp.src('./app/css/scss/*.scss')
    .pipe(sass())
    .on('error', sass.logError)
    .pipe(concat('style.css'))
    .pipe(minifyCss({ keepSpecialComments: 0  }))
    .pipe(rename({ extname: '.min.css' }))
    .pipe(gulp.dest('./app/css'));
});
