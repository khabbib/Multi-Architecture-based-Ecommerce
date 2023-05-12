import { error } from '@sveltejs/kit';

/** @type {import('./$types').PageLoad} */
export function load({ params }) {
    if (params.slug === 'product') {
        return {
            title: 'Product',
            content: 'Welcome...'
        };
    }

    throw error(404, 'Not found');
}