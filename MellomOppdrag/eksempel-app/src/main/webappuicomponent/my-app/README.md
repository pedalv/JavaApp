## [React, TypeScript, and TDD tutorial](https://www.youtube.com/user/JetBrainsTV/videos)

![React_TypeScript_TDD](https://github.com/pedalv/JavaApp/blob/master/MellomOppdrag/React_TypeScript_TDD.PNG)

## NodeJs
```
node -v
v14.15.4

$ npm -v
6.14.8

$ npx -v
6.14.8
```

## IDE
- WebStrom
- Intellij Idea
- Visual Studio Code

## Tips og råd
- https://plugins.jetbrains.com/plugin/10456-prettier
- [div>h2](https://www.jetbrains.com/help/idea/using-zen-coding-support.html)
- https://plugins.jetbrains.com/plugin/7450-emmet-everywhere
- [testing-library - for ny React](https://testing-library.com/docs/)
- https://github.com/testing-library/user-event
- [enzyme - det er gammel](https://enzymejs.github.io/enzyme/)
- [CodeSandbox](https://codesandbox.io/) or [layground](https://jscomplete.com/playground)
- React 35k === Inferno 9k | PREACT 3k 
- https://magic.reactjs.net/htmltojsx.htm
- https://www.npmjs.com/package/htmltojsx
- TypeScript | BABEL === tranapile JSX
- [Babel is a JavaScript compiler](https://babeljs.io/)  
- [React Starter Projects](https://www.javascriptstuff.com/react-starter-projects/)
- State Management: Plain React (Component state) | Flux | Redux (Cebtralized state) | MobX (Observable state)
- [React Commonly Faced Problems](https://jscomplete.com/learn/react-beyond-basics/react-cfp)
- [Why React](https://jscomplete.com/learn/react-beyond-basics/why-react)
- [React Developer Tools](https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi/related?hl=en)
- [Draft: JSX Specification](http://facebook.github.io/jsx/)
- [css-in-js](https://github.com/MicheleBertoli/css-in-js)
- [GitHub pedalv](https://api.github.com/users/pedalv)
- [react-axios-react](https://www.digitalocean.com/community/tutorials/react-axios-react)
- [Handling Axios error in React](https://stackoverflow.com/questions/47005457/handling-axios-error-in-react )
- [react-beyond-basics](https://jscomplete.com/learn/react-beyond-basics)
- [React Hooks Deep Dive](https://jscomplete.com/learn/react-beyond-basics/react-hooks-deep-dive)
- [The Always-recent Guide to Creating Your Own Development Environment for Node and React](https://jscomplete.com/reactful)
- [rgs-template](https://github.com/jscomplete/rgs-template)
- [rgs-start-match](https://github.com/jscomplete/rgs-start-match)
- [react-beyond-basics](http://jscomplete.com/react-beyond-basics)
- [why-graphql](http://jscomplete.com/why-graphql)

> Recomendations

- Dev environment: create-react-app
- Classes or Functions: Functions
- Types: ProTypes or TypeScript
- State: Plain React 
- Styling: css | less | sass | etc

> Components

- [Fluent UI](https://developer.microsoft.com/en-us/fluentui#/)
- [Material-UI](https://material-ui.com/)
- [React Bootstrap](https://react-bootstrap.github.io/)
- [awesome-react](https://github.com/enaqx/awesome-react)

> Ecosystem

- React Router
- Redux | Mobx
- Jest |  Mocha | Jasmine | Tape  QUnit | AVA
- GrapgQL
- Next.js

## komandoer 
- npm init react-app react-eksempel-app typescript
- npx create-react-app my-app --template typescript
- npm install --save-dev --save-exact prettier
- npm install --save-dev axios
- npm install --save-dev json-server 
- npm install @testing-library/user-event @testing-library/dom --save-dev 
- npm install --save-dev  @testing-library/react (browser is not need)   
- npm i --save-dev enzyme enzyme-adapter-react-16
- npm run-script start
- npm i -g create-react-app && create-react-app my-app --template typescript
- npm run eject
- npx reactfull start-match
- npm init -y
- npm install react react-dom next
- npm install --save-dev bootstrap react-toastify
- npm list
- npm audit
- npm install lodash@latest
- npm install eslint --saveDev
- ./node_modules/.bin/eslint --init
- ./node_modules/.bin/eslint lib/**.js
- npm install mocha --saveDev
- ./node_modules/.bin/mocha lib/utils.test.js

## React: The Big Picture
- React (Library) | Angular | View | Ember (Framework)
- Components for Web apps (react-dom)
- Static sites with  Gatsby and Phenomic
- Mobile with Recat Native (react-native)
- Desktop with Electron for run on MAC and WINDOWS
- Server-rendered with NEXT.js (ReactDomServer.renderToString())
- Virtual Reality Websites and 360 experience with React VR (react-vr)

## [React Hooks](https://github.com/pkellner/pluralsight-course-using-react-hooks)
- useState: lets track state
- useRef: Primarily used to allow access directly to an element in the DOM
- useEffect: lets set a state when component start and finish
- useContext
- useReducer: [Typing a useReducer React hook in TypeScript](https://www.sumologic.com/blog/react-hook-typescript/), [React Context with useReducer and Typescript](https://dev.to/elisealcala/react-context-with-usereducer-and-typescript-4obm)
- useCallback
- useMemo
- [React Hooks with Typescript : UseCallback, UseMemo, UseContext And UseRef](https://codersera.com/blog/react-hooks-with-typescript-usecallback-usememo/)
- [To TypeScript or Not To TypeScript](https://peterkellner.net/2019/09/25/To-TypeScript-or-Not-To-TypeScript/)

## React component Tree
- Props go down
- Functions go up
- Global Store/State Manager (check later some examples)

# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).
