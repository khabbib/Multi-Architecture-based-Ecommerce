function navigate(path) {
  // window.history.pushState({}, null, path)
  // document.dispatchEvent(new Event('navigation'));
  window.location.pathname = '/' + path;
}


export { navigate };