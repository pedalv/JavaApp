# AngularEksempelApp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 10.1.3.

# Angular Best Practices

![Angular 8 Main parts](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/Angular2%2B_8_Main_parts.PNG)

#### [Usig Immutability === angular-change-detection-strategy](https://www.digitalocean.com/community/tutorials/angular-change-detection-strategy)

```
user.classes = user.classes || []; => Object.assign({}, user, {classes: user.classes || [] });

this.currentUser.classes.push(classId); => this.currentUser = Object.assign({}, this.currentUser, {classes: this.currentUser.classes.concat([classId])});

this.visibleClasses[0].professor = "Zebraman"; => this.visibleClasses = [
    Object.assign(this.visibleClasses[0], {professor: "Zebraman"}),
    ...this.visibleClasses.slice(1)
];
```

#### Architecture Planning

1. App Overview
2. App Features
3. Domain Security
4. Domain Rules
5. Logging
6. Services/Communication
7. Data Models
8. Feature Components => Eager/Layz Load Feature
9. Shared Functionality

![Angular Injectors](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/AngularInjectors.PNG)


#### [Angular coding style guide](https://angular.io/guide/styleguide)

- [flat](https://angular.io/guide/styleguide#flat)
- [feature-modules](https://angular.io/guide/styleguide#feature-modules)
- [shared-feature-module](https://angular.io/guide/styleguide#shared-feature-module)
- [lifecycle-hooks](https://angular.io/guide/lifecycle-hooks)

#### [Angular Library](https://docs.npmjs.com/packages-and-modules/)

- https://docs.npmjs.com/packages-and-modules/contributing-packages-to-the-registry
- https://docs.npmjs.com/packages-and-modules/

```
ng new my-project
ng generate library my-lib
ng build my-lib
cd dist/my-lib
npm publish
```

#### Angular Modules

![Recommended Modules](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/AngularRecommendedModules.PNG)

![Angular Organazing App Modules](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/Angular10OrganizingAppMosules.PNG)

![Child Routes and Component](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/Angular10ChildRoutesandComponents.PNG)


## Document and article
- [Angular 2 and Spring Boot](https://www.youtube.com/c/AlmightyJava/search?query=Angular%202%20and%20Spring%20Boot)
- [Desktop to Web: Basic Route Navigation in Angular 9](https://www.youtube.com/watch?v=KkluJjQ4b5E)
- [3+ Ways to Add Bootstrap 4 to Angular 10/9 With Example & Tutorial](https://www.techiediaries.com/angular-bootstrap/)
- [Styling An Angular 10 Example App with Bootstrap 4 Navbar, Jumbotron, Tables, Forms and Cards](https://www.techiediaries.com/angular/style-angular-10-example-bootstrap-4/)
- [Communicating with backend services using HTTP](https://angular.io/guide/http)
- [Configure a proxy for your API calls with Angular CLI](https://juristr.com/blog/2016/11/configure-proxy-api-angular-cli/)
- [Intercepting Requests and Responses (SPRING SEGURITY)](https://angular.io/guide/http#intercepting-requests-and-responses)
- [Pipes API list](https://angular.io/guide/architecture-components#templates-and-views)
- [Sort/OrderBy pipe in Angular 5/6/7/8/9 (updated)](https://medium.com/@Mdmoin07/sort-pipe-in-angular-6-7-f22475cc4054)
- [How to sort table rows according to a column in Angular 9](https://medium.com/nerd-for-tech/how-to-sort-table-rows-according-column-in-angular-9-b04fdafb4140)
- [Introduction to services and dependency injection](https://angular.io/guide/architecture-services)
- [NGRX](https://ngrx.io/)
- [PutsReq](https://putsreq.com/)
- [angular.io](https://angular.io/resources?category=development)
- [awesome-angular-components](https://github.com/brillout/awesome-angular-components)

> Prod miljø: Apache 2  or [Nginx](https://www.nginx.com/)

- [Cross-Origin Resource Sharing (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS)
- [Unit Testing Angular 10/9/8 Application with Jasmine & Karma](https://www.positronx.io/angular-unit-testing-application-with-jasmine-karma/)
- [Angular Best Practices](https://app.pluralsight.com/library/courses/best-practices-angular/table-of-contents)

>  [Hooking into the component lifecycle](https://angular.io/guide/lifecycle-hooks)

> Compilation 

```
npm start -- --prod === for development (minimize blandles)
npm run build -- --prod === for production in dist folder

npm install -g source-map-explorer
du -sh *
npm run build  "--prod" "--sourcemaps=true" 
source-map-explorer <file_name_in_dist_mapper>
```

> [Understanding Change Detection Strategy in Angular](https://www.digitalocean.com/community/tutorials/angular-change-detection-strategy)

> [Angular Architecture and Best Practices](https://app.pluralsight.com/library/courses/angular-architecture-best-practices/table-of-contents)

```
ng new my-project
ng generate library my-lib
ng build my-lib
https://docs.npmjs.com/packages-and-modules/contributing-packages-to-the-registry
https://docs.npmjs.com/packages-and-modules/
cd dist/my-lib
npm publish
```

- Install ng
```
    npm install -g @angular/cli ->  install the Angular CLI globally. @next for beta versjon
```

- Create
```
    ng new my-app -> Create a new project
    cd my-app
```

- Angular APP
```
    ng serve --open or ng serve --open --host 0.0.0.0 --port 4200
    ng generate component xyz
    ng add @angular/material
    ng add @angular/pwa
    ng add <_Dependency_>
    ng test
    ng build --prod       
```

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

```
.\MellomOppdrag\eksempel-app\src\main\webappplatform\angular-eksempel-app>ng serve --open
Compiling @angular/core : es2015 as esm2015
Compiling @angular/common : es2015 as esm2015
Compiling @angular/platform-browser : es2015 as esm2015
Compiling @angular/router : es2015 as esm2015
Compiling @angular/platform-browser-dynamic : es2015 as esm2015

chunk {main} main.js, main.js.map (main) 59.7 kB [initial] [rendered]
chunk {polyfills} polyfills.js, polyfills.js.map (polyfills) 141 kB [initial] [rendered]
chunk {runtime} runtime.js, runtime.js.map (runtime) 6.15 kB [entry] [rendered]
chunk {styles} styles.js, styles.js.map (styles) 12.6 kB [initial] [rendered]
chunk {vendor} vendor.js, vendor.js.map (vendor) 2.62 MB [initial] [rendered]
Date: 2020-09-30T07:07:36.477Z - Hash: 03e49c254d639867dbf2 - Time: 7265ms
** Angular Live Development Server is listening on localhost:4200, open your browser on http://localhost:4200/ **
: Compiled successfully.

Date: 2020-09-30T07:07:37.955Z - Hash: 03e49c254d639867dbf2
5 unchanged chunks

Time: 836ms
: Compiled successfully.

```

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).


## Store (State)

![Angular Services](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/Angular_ServicesStore1.PNG)
![Angular Service Store](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/Angular_ServicesStore2.PNG)

![Angular Store Statte](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/AngularStoreState.PNG)
![Angular Redux Principles](https://raw.githubusercontent.com/pedalv/JavaApp/master/MellomOppdrag/AngularReduxPrinciples.PNG)

## Document and article
- [Protractor configuration file](https://github.com/angular/protractor/blob/master/lib/config.ts)
- [tsconfig](https://angular.io/config/tsconfig)
- [TypeScript configuration](https://angular.io/guide/typescript-configuration)
- [Karma Runner Configuration File](https://karma-runner.github.io/1.0/config/configuration-file.html)
- [Browserslist#queries](https://github.com/browserslist/browserslist#queries)
- [Browser support](https://angular.io/guide/browser-support)
- [In-app navigation: routing to views](https://angular.io/guide/router#!#named-outlets)
- [Scalable Vector Graphics (SVG)](https://www.w3.org/2000/svg)
- [Tour of Heroes app and tutorial](https://angular.io/tutorial)
- [CLI Overview and Command Reference](https://angular.io/cli)
- [API - GUIDE - OTHER - START - TUTORIAL](https://angular.io/guide/animation)
- [Angular CLI](https://cli.angular.io/)
- [Angular Augury](https://augury.rangle.io/)
- [xlink -  XML Linking Language (XLink) specification](http://www.w3.org/1999/xlink)
- [Protractor is an end-to-end test framework for Angular and AngularJS applications](https://www.protractortest.org/)
- [Angular GitHub](https://github.com/angular/angular)
- [EditorConfig](https://editorconfig.org/)
- [Ignoring files](http://help.github.com/ignore-files/)
- [AngularJS in 10 Minutes](https://www.youtube.com/watch?v=nTuOQ8LP-rU)
- [Learn AngularJS in 5 Minutes](https://www.youtube.com/watch?v=cEbBvAEDjrg)
- [Angular2 in 15min](https://www.youtube.com/watch?v=U3qshbC4fLo)
- [Angular 10 Tutorial - Interpolation](https://www.youtube.com/watch?v=Kh-9qyAxXm0)
- [What is NgRx? === Redux Pattern + Angular](https://ngrx.io/docs)
- [Angular in-memory-web-api](https://github.com/angular/in-memory-web-api)

##HttpClient and RxJS Operators

- switchMap: merge observable into other observable

```
people : [{
    felt1: 'blabla',
    homeworld: 'https://...',
    felt3:  'blabla',
    ...
}]

import { map, switchMap } from 'rxjs/operators';

getCharacterAndHomeworld() {
    const url = this.baseUrl + 'people/1';
    return this.http.get(url)
      .pipe(
        switchMap(character => {
          return this.http.get(character['homeworld'])
            .pipe(
              map(hw => {
                character['homeworld'] = hw;
                return character;
              })
            )
        })
      );
  }
```

- mergeMap: merge data into a observable

```
import { switchMap, mergeMap, concatMap, toArray } from 'rxjs/operators';

//get all 10 persons with a link to homeworld => results
getCharactersAndHomeworlds() {
    return this.http.get(this.baseUrl + 'people') //1 get array of 10 persons
      .pipe(
        switchMap(res => {
          // convert array to observable
          return from(res['results']); //2 convert to Observable (concatMap for keep order)
        }),
        // concatMap((person: any) => {
        mergeMap((person: any) => { 
            return this.http.get(person['homeworld']) //3 pass each one to fetch homeworld data
              .pipe(
                map(hw => {
                  person['homeworld'] = hw;
                  return person;
                })
              );
        }),
        toArray()
      );
  }
```

- forkJoin: many calls and notify when last value/result is return 

```
import { forkJoin, of} from 'rxjs';
import { tap, map } from 'rxjs/operators';

getCharacters() {
    return this.http.get(this.baseUrl + 'people')
      .pipe(
        tap(res => {
          console.log('Before getCharacters map');
        }),
        map(res => {
          return res['results'];
        }),
        tap(res => {
          console.log('After getCharacters map');
        })
      );
  }

getPlanets() {
    return this.http.get(this.baseUrl + 'planets')
      .pipe(
        tap(res => {
          console.log('Before getPlanets map');
        }),
        map(res => {
          return res['results'];
        }),
        tap(res => {
          console.log('After getPlanets map');
        })
      );
  }

getCharactersAndPlanets() {
    return forkJoin(
      this.getCharacters(), //res[0]
      this.getPlanets() //res[1]
    )
    .pipe(
      map((res) => {
        return { characters: res[0], planets: res[1] };
      }),
      catchError(error => of(error))
    );
  }
```

- Component

```
@Component({
  selector: 'app-httpclientrxjs',
  templateUrl: './httpClientRxJS.component.html',
  styleUrls: [ './httpClientRxJS.component.css' ]
})
export class HttpClientRxJSComponent implements OnInit  {

  charactersWithHomeworld$: Observable<any>;
  characterWithHomeworld$: Observable<{}>;
  charactersAndPlanets: { characters: any[], planets: any[]};
  characters$: Observable<any[]>;
  planets$: Observable<any[]>;
  ...
  constructor(private dataService: HttpClientRxJSService) { }
  ...
  ngOnInit() {
    // Get both characters and planets at same time
    // Uses forkJoin
    this.dataService.getCharactersAndPlanets()
      .subscribe(data => this.charactersAndPlanets = data);

    // Get character and its homeworld
    // Uses switchMap
    this.characterWithHomeworld$ = 
      this.dataService.getCharacterAndHomeworld();

    this.charactersWithHomeworld$ = this.dataService.getCharactersAndHomeworlds();
    ...
  }
  ...
```
