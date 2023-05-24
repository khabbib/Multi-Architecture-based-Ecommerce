import { navigate } from "./navigator";


async function checkAuth() {
    // Check if user is authenticated
		const token = localStorage.getItem('sessionToken'); // Retrieve the token from cookie or local storage
        if(token && window.location.pathname === '/login'){
            console.log('token: ', token);
            const checkAuth = await fetch('http://localhost:8080/auth/check', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ token }),
        })
            .then((res) => {
                navigate('dashboard');
                console.log('check Response: ', res);

            })
        }
}


export { checkAuth };