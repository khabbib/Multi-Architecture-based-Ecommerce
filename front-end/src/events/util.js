import { navigate } from "./navigator";


function checkAuth() {
    // Check if user is authenticated
		const token = localStorage.getItem('sessionToken'); // Retrieve the token from cookie or local storage
        if(token){
            const checkAuth = fetch('http://localhost:8080/auth/check', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ token }),
        })
            .then((res) => res.json())
            .then((res) => {
                console.log('check Response: ', res);
            })
            .catch((err) => {
            });

            
        }
}


export { checkAuth };