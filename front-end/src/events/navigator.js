function navigateTo(path, message) {
	const url = new URL(window.location.href);
	url.pathname = "/" + path;
	if(message !== null){
		url.searchParams.set("message", message);
	}
	window.location.href = url.toString();
}

function preInitializePage(){
    const url = new URL(window.location.href);
    const params = url.searchParams;
    if (params.has("message")) {
        const error = params.get("message");
        params.delete("message"); // Remove the message parameter from the URL
        window.history.replaceState({}, "", url.toString()); // Update the URL without the message parameter
        return {
            status: "success",
            error: error,
        };
    }

    return null;

}

export { navigateTo, preInitializePage };
