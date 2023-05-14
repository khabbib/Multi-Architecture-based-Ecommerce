import { redirect } from '@sveltejs/kit';


/** @type {import('./$types').Actions} */
export const actions = {
    default: async ({ request, cookies }) => {
        const form = await request.formData();
        const email = form.get('email');
        const password = form.get('password');

        if (!email || !password) return 'Email and Password are required';

        
        throw redirect(307, '/dashboard');
    }
};