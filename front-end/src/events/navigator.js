function navigate(path) {
  // window.history.pushState({}, null, path)
  // document.dispatchEvent(new Event('navigation'));
  console.log('navigate to', path);
  window.location.pathname = '/' + path;
}


export { navigate };