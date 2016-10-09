// grab our gulp packages
var gulp = require('gulp');
var uglify = require('gulp-uglify');
var concat = require('gulp-concat');
var sourcemaps = require('gulp-sourcemaps');
var connect = require('gulp-connect');
var cleanCSS = require('gulp-clean-css');
var autoprefixer = require('gulp-autoprefixer');
var plumber = require('gulp-plumber');
var babel = require('gulp-babel');
var del = require('del');
var zip = require('gulp-zip');
var runSequence = require('run-sequence');
var inject = require('gulp-inject');
var gutil = require('gulp-util');

// Less plugins
var less = require('gulp-less');
var LessAutoprefix = require('less-plugin-autoprefix');
var lessAutoprefix = new LessAutoprefix({
    browser: ['last 2 versions']
});

// File paths
var DIST_PATH = './dist/';
var SCRIPTS_PATH = './src/app/**/*.js';
var CSS_PATH = './src/css/**/*.css';
var LESS_PATH = './src/app/**/*.less';

var distRoot = './dist/',
    srcRoot = './src/',
    srcApp = srcRoot + 'app/';

var files = {
    index: {
        list: ['index.html'],
        listPath: srcRoot
    },
    templates: {
        list: ['**/*.html'],
        listPath: srcApp,
        cache: ['templates.js'],
        cachePath: srcApp + 'templates/'
    },
    envSettings: {
        rawPath: srcRoot + 'settings/',
        list: ['envSettings.js'],
        listPath: srcApp
    },
    assets: {
        list: ['**/*'],
        listPath: srcRoot + 'assets',
        distPath: distRoot + 'assets/'
    },
    i18n: {
        list: ['**/*.json'],
        listPath: srcRoot + 'i18n/',
        distPath: distRoot + 'i18n/'
    },
    scripts: {
        list: ['envSettings.js', 'app.js', 'templates/templates.js', '**/*.js'],
        listPath: srcApp,
        distPath: distRoot + 'js/',
        compiled: 'stor.min.js'
    },
    css: {
        list: ['reset.css', '**/*.css'],
        listPath: srcRoot + 'css/',
        distPath: distRoot + 'css/',
        compiled: 'storCss.css'
    },
    less: {
        list: ['common/**/*.less', 'components/**/*.less', 'pages/**/*.less'],
        listPath: srcApp,
        distPath: distRoot + 'css/',
        compiled: 'storLess.css'
    },
    jsLib: {
        list: ['jquery/jquery-3.1.0.min.js', 'angularjs/angular.min.js', 'angularjs/**/*.js', 'bootstrap/js/**/*.js', 'bootstrap/ui-bootstrap/**/*.js'],
        listPath: './lib/',
        distPath: distRoot + 'lib/',
        compiled: 'libs.min.js'
    },
    cssLib: {
        list: ['bootstrap/css/bootstrap.min.css', 'bootstrap/css/**/*.css'],
        listPath: './lib/',
        distPath: distRoot + 'css/',
        compiled: 'lib.css'
    },
    testlibs: {
        list: ['**/*.js'],
        listPath: './test/lib/'
    },
    tests: {
        list: ['**/*Test.js'],
        listPath: './test/unit/'
    }
};

function getFiles(files, path) {
    return files.map(function (file) {
        return path + file;
    });
}

// INI - FILES TO THE DIST FOLDER

// Styles For CSS
gulp.task('stylesCss', function() {
    console.log('starting stylesCss task');
    return gulp.src(getFiles(files.css.list, files.css.listPath))
        .pipe(plumber(function(err) {
            console.log('stylesCss Task Error');
            console.log(err);
            this.emit('end');
        }))
        .pipe(sourcemaps.init())
            .pipe(autoprefixer())
            .pipe(concat(files.css.compiled))
            .pipe(cleanCSS())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(files.css.distPath))
        .pipe(connect.reload());
});

// Styles For less
gulp.task('stylesLess', function() {
    console.log('starting stylesLess task');
    return gulp.src(getFiles(files.less.list, files.less.listPath))
        .pipe(plumber(function(err) {
            console.log('StylesLess Task Error');
            console.log(err);
            this.emit('end');
        }))
        .pipe(sourcemaps.init())
        .pipe(concat(files.less.compiled))
        .pipe(less({
            plugins: [lessAutoprefix]
        }))
        .pipe(cleanCSS())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(files.less.distPath))
        .pipe(connect.reload());

});

// Scripts
gulp.task('scripts', function() {
    console.log('starting scripts task');
    return gulp.src(getFiles(files.scripts.list, files.scripts.listPath))
        .pipe(plumber(function(err) {
            console.log('Scripts Task Error');
            console.log(err);
            this.emit('end');
        }))
        .pipe(sourcemaps.init())
            .pipe(babel({
                presets: ['es2015']
            }))
            .pipe(uglify())
            .pipe(concat(files.scripts.compiled))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(files.scripts.distPath))
        .pipe(connect.reload());
});

// Images
gulp.task('images', function () {
    console.log('starting images task');
})

// Thrird party code --> ANGULAR AND BOOTSTRAP

gulp.task('cssLib', function () {
    return gulp.src(getFiles(files.cssLib.list, files.cssLib.listPath))
        .pipe(sourcemaps.init())
            .pipe(concat(files.cssLib.compiled))
            .pipe(cleanCSS())
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(files.cssLib.distPath));
});

gulp.task('jsLib', function () {
    return gulp.src(getFiles(files.jsLib.list, files.jsLib.listPath))
        .pipe(sourcemaps.init())
            .pipe(uglify())
            .pipe(concat(files.jsLib.compiled))
        .pipe(sourcemaps.write())
        .pipe(gulp.dest(files.jsLib.distPath));
});

// END - FILES TO THE DIST FOLDER

// STARTING UP AND REFRESHING CYCLE

// Server
gulp.task('connect', function() {
    connect.server({
        root: './dist',
        port: 3001,
        livereload: true
    });
    console.log('starting server');
});

gulp.task('html', function () {
    gulp.src('./src/*.html')
        .pipe(connect.reload());
});

gulp.task('watch', function () {
    gulp.watch(['./src/*.html'], ['html']);
    gulp.watch(SCRIPTS_PATH, ['scripts']);
    gulp.watch(LESS_PATH, ['stylesLess']);
    gulp.watch(CSS_PATH, ['stylesCss']);
});

gulp.task('clean', function() {
    return del.sync([
        DIST_PATH
    ]);
});

gulp.task('build-html', function() {
    return;
})
gulp.task('run', function (callback) {
    runSequence('connect', 'watch', callback);
});

gulp.task('index', function () {
    return gulp.src(files.index.list[0], {cwd: srcRoot})
        // css
        .pipe(inject(gulp.src(files.cssLib.compiled,
            {cwd: files.cssLib.distPath, read: false}),
            {
            name: 'libs',
            addPrefix: 'css',
            addRootSlash: false
            }
        ))
        //less
        .pipe(inject(gulp.src(files.less.compiled,
            {cwd: files.less.distPath, read: false}),
            {
            name: 'own',
            addPrefix: 'css',
            addRootSlash: false
            }
        ))
        //libs
        .pipe(inject(gulp.src(files.jsLib.compiled,
            {cwd: files.jsLib.distPath, read: false}),
            {
            name: 'libs',
            addPrefix: 'js',
            addRootSlash: false
            }
        ))
        //own scripts
        .pipe(inject(gulp.src(files.scripts.compiled,
            {cwd: files.scripts.distPath, read: false}),
            {
            name: 'scripts',
            addPrefix: 'js',
            addRootSlash: false
            }
        ))

        .pipe(gulp.dest(distRoot));
});

gulp.task('build', function(callback) {
    runSequence('clean',
        ['jsLib', 'cssLib'],
        ['scripts', 'stylesCss', 'stylesLess', 'images'],
        'build-html',
        ['index'],
        callback);
});

// gulp.task('build', function (callback) {
//     runSequence('templates', 'assets', 'less', 'envSettings', 'lint', 'scripts', 'ts-compile', ['index'], callback);
// });

gulp.task('default', function (callback) {
    gutil.log('Gulp is running');
    runSequence('build', 'run', callback);
});

gulp.task('export', function() {
    return gulp.src('src/**/*')
        .pipe(zip('website.zip'))
        .pipe(gulp.dest('./'));
});