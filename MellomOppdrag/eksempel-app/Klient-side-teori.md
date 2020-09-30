# Front-end web development
Front-end web development is the practice of converting data to a graphical interface, through the use of HTML, CSS, and JavaScript, so that users can view and interact with that data.

##Tips og Råd
```
    node -v === v12.18.4 
    npm -v === 6.14.8 
    npx -v === 6.14.8
```

```
    rm -Rf node_modules
    rm -f package-lock.json

    npm install --save-dev webpack
    npm install --save-dev webpack-dev-server
    npm install eller npm i
    
    npm update
    npm audit fix --force
```
    
- [npm-init](https://docs.npmjs.com/cli/init)

React is a JavaScript library for building user interfaces or UI components. 
```
    npm install -g create-react-app (not need)
    create-react-app my-first-app
    eller
    npm init react-app my-first-app
```
- [react-scripts](https://www.npmjs.com/package/react-scripts)
```
    npm init react-app my-app
```
- [react-scripts-ts](https://www.npmjs.com/package/react-scripts-ts) === 
```
    npm init react-app my-app --template typescript
```
- React APP
```
    npm start
    npm test
    `npm run eject` (webpack, Babel, ESLint, etc) 
    npm run build
```
- [React And Spring Boot](https://www.youtube.com/c/AlmightyJava/search?query=React%20And%20Spring%20Boot)

Angular is a platform for building mobile and desktop web applications === MV (Model View).
```
    ng update @angular/cli --migrate-only --from=1.6.6
```
    
- Install ng
```
    npm install -g @angular/cli ->  install the Angular CLI globally.
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
- [Angular 2 and Spring Boot](https://www.youtube.com/c/AlmightyJava/search?query=Angular%202%20and%20Spring%20Boot)
- [Desktop to Web: Basic Route Navigation in Angular 9](https://www.youtube.com/watch?v=KkluJjQ4b5E)

## Klient side
- [ECMAScript === JavaScript standard](https://en.wikipedia.org/wiki/JavaScript)
- [JavaScript - ECMAScript 2020](https://en.wikipedia.org/wiki/JavaScript)
- [TypeScript: Typed JavaScript at Any Scale](https://www.typescriptlang.org/)
- [Babel · The compiler for next generation JavaScript](https://babeljs.io/)


## Modern JavaScript frameworks
- [React: A JavaScript library for building user interfaces](https://reactjs.org/)
- [Redux:  A Predictable State Container for JS Apps](https://redux.js.org/)
- [Flow: A Static Type Checker for JavaScript](https://flow.org/)
- [Svelte • Cybernetically enhanced web apps](https://svelte.dev/ )
- [Angular 2+:  Platform for building mobile and desktop web application](https://angular.io/)
- [Vue.js: The Progressive JavaScript Framework.](https://vuejs.org/)
- [Web components](https://www.webcomponents.org/)
- [Lightning Components](https://developer.salesforce.com/docs/atlas.en-us.lightning.meta/lightning/intro_framework.htm)
- [Lightning Components Samples](https://developer.salesforce.com/docs/component-library/overview/components)

## Kunnskap om standarder for universell utforming av løsninger
- [Web Content Accessibility Guidelines (WCAG) 2.1](https://www.w3.org/TR/WCAG21/)
- [Authoring Tool Accessibility Guidelines (ATAG) Overview](https://www.w3.org/WAI/standards-guidelines/atag/)
- [WAI-ARIA Overview](https://www.w3.org/WAI/standards-guidelines/aria/)

## Universell utforming
- [HTML](https://en.wikipedia.org/wiki/HTML)
- [CSS: a style sheet language](https://en.wikipedia.org/wiki/CSS)
- [LESS: It's CSS, with just a little more.](http://lesscss.org/)
- [Sass: Syntactically Awesome Style Sheets](https://sass-lang.com/)
  
## Serverside-rendering 
- [Next.js - Build static and dynamic websites and web applications.](https://nextjs.org/) 

## Bruk av state-containers for skjemadata på frontend
- [Formik - The React forms API](https://formik.org/)
- [final-form](https://final-form.org/react)

## Bygg og oppsett av frontend-applikasjoner 
- [Node.js® is a JavaScript runtime built on Chrome's V8 JavaScript engine](https://nodejs.org/en/)
- [npm: Build amazing things](https://www.npmjs.com/), [About npm](https://docs.npmjs.com/about-npm/)
- [Express - Node.js web application framework](https://expressjs.com/)
- [webpack is a module bundle](https://webpack.js.org/)
- [Rollup provides a JavaScript API which is usable from Node.js](https://rollupjs.org/guide/en/)
 
## Test i frontend-utvikling 
- [Mocha: the fun, simple, flexible JavaScript test framework](https://mochajs.org/)
- [Jest: Delightful JavaScript Testing](https://jestjs.io/)
- [Enzyme](https://enzymejs.github.io/enzyme/)
- [react-testing-library](https://testing-library.com/docs/react-testing-library/intro)


## Testverktøy for ende-til-ende-testing på frontend, f.eks. 
- [Nightwatch.js | Node.js powered End-to-End testing framework](https://nightwatchjs.org/)
- [A node.js tool to automate end-to-end web testing | TestCafe](https://devexpress.github.io/testcafe/)
- [JavaScript End to End Testing Framework | cypress.io](https://www.cypress.io/)
