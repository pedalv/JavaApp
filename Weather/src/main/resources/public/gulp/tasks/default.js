'use strict';

var gulp = require('gulp'),
    runSequence = require('run-sequence');

gulp.task('default', function(done){
	runSequence(
		['weather'],
		//'',
		done);
});

//gulp.task('default', ['sass', 'sass-cache']);