<script>
	import { onMount } from 'svelte';
	import { checkAuthInLoginPage, validateLogin } from '../../events/util.js';
	import { navigateTo, preInitializePage } from '../../events/navigator.js';
	import Message from '../../components/message.svelte';

	let email = '',
		password = '',
		error = null;

	onMount(() => {
		checkAuthInLoginPage();
		error = preInitializePage();
	});

	const handleLogin = async () => {
		error = await validateLogin(email, password);
	};
</script>

<section class="h-[80vh] bg-green-50">
	<div class="h-full w-full flex flex-col md:flex-row justify-center items-center">
		<!-- Left column container with background-->
		<!-- Right column container -->
		<div
			class="mb-12 md:mb-0 md:w-8/12 lg:w-5/12 xl:w-5/12 border rounded-md"
			style="padding: 5rem;"
		>
			<Message {error} />

			<form on:submit|preventDefault={() => handleLogin()}>
				<!--Sign in section-->
				<div class="flex flex-row items-center justify-around">
					<div>
						<p class="mb-0 mr-4 text-lg">Sign in with</p>
					</div>
					<div>
						<!-- Facebook -->
						<button
							type="button"
							data-te-ripple-init
							data-te-ripple-color="light"
							class="inlne-block mx-1 h-9 w-9 rounded-full bg-primary uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]"
						>
							<!-- Facebook -->
							<svg
								xmlns="http://www.w3.org/2000/svg"
								class="mx-auto h-3.5 w-3.5"
								fill="currentColor"
								viewBox="0 0 24 24"
							>
								<path
									d="M9 8h-3v4h3v12h5v-12h3.642l.358-4h-4v-1.667c0-.955.192-1.333 1.115-1.333h2.885v-5h-3.808c-3.596 0-5.192 1.583-5.192 4.615v3.385z"
								/>
							</svg>
						</button>

						<!-- Twitter -->
						<button
							type="button"
							data-te-ripple-init
							data-te-ripple-color="light"
							class="inlne-block mx-1 h-9 w-9 rounded-full bg-primary uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]"
						>
							<!-- Twitter -->
							<svg
								xmlns="http://www.w3.org/2000/svg"
								class="mx-auto h-3.5 w-3.5"
								fill="currentColor"
								viewBox="0 0 24 24"
							>
								<path
									d="M24 4.557c-.883.392-1.832.656-2.828.775 1.017-.609 1.798-1.574 2.165-2.724-.951.564-2.005.974-3.127 1.195-.897-.957-2.178-1.555-3.594-1.555-3.179 0-5.515 2.966-4.797 6.045-4.091-.205-7.719-2.165-10.148-5.144-1.29 2.213-.669 5.108 1.523 6.574-.806-.026-1.566-.247-2.229-.616-.054 2.281 1.581 4.415 3.949 4.89-.693.188-1.452.232-2.224.084.626 1.956 2.444 3.379 4.6 3.419-2.07 1.623-4.678 2.348-7.29 2.04 2.179 1.397 4.768 2.212 7.548 2.212 9.142 0 14.307-7.721 13.995-14.646.962-.695 1.797-1.562 2.457-2.549z"
								/>
							</svg>
						</button>

						<!-- Linkedin -->
						<button
							type="button"
							data-te-ripple-init
							data-te-ripple-color="light"
							class="inlne-block mx-1 h-9 w-9 rounded-full bg-primary uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]"
						>
							<!-- Linkedin -->
							<svg
								xmlns="http://www.w3.org/2000/svg"
								class="mx-auto h-3.5 w-3.5"
								fill="currentColor"
								viewBox="0 0 24 24"
							>
								<path
									d="M4.98 3.5c0 1.381-1.11 2.5-2.48 2.5s-2.48-1.119-2.48-2.5c0-1.38 1.11-2.5 2.48-2.5s2.48 1.12 2.48 2.5zm.02 4.5h-5v16h5v-16zm7.982 0h-4.968v16h4.969v-8.399c0-4.67 6.029-5.052 6.029 0v8.399h4.988v-10.131c0-7.88-8.922-7.593-11.018-3.714v-2.155z"
								/>
							</svg>
						</button>
					</div>
				</div>

				<!-- Separator between social media sign in and email/password sign in -->
				<div
					class="my-4 flex items-center before:mt-0.5 before:flex-1 before:border-t before:border-neutral-300 after:mt-0.5 after:flex-1 after:border-t after:border-neutral-300"
				>
					<p class="mx-4 mb-0 text-center font-semibold dark:text-black">Or</p>
				</div>

				<!-- Email input -->
				<div class="relative mb-6" data-te-input-wrapper-init>
					<label style="color: gray;" for="exampleFormControlInput2">Email address </label>
					<input
						bind:value={email}
						style="border: 1px solid #e5e5e5; color: #000;"
						type="text"
						name="email"
						class="peer text-black min-h-[auto] w-full rounded border-0 bg-transparent px-3 py-[0.32rem] leading-[2.15] outline-none transition-all duration-200 ease-linear focus:placeholder:opacity-100 data-[te-input-state-active]:placeholder:opacity-100 motion-reduce:transition-none dark:text-neutral-200 dark:placeholder:text-neutral-200 [&:not([data-te-input-placeholder-active])]:placeholder:opacity-0"
						id="exampleFormControlInput2"
						placeholder="Email address"
					/>
				</div>

				<!-- Password input -->
				<div class="relative mb-6" data-te-input-wrapper-init>
					<label style="color: gray;" for="exampleFormControlInput22">Password </label>
					<input
						bind:value={password}
						name="password"
						style="border: 1px solid #e5e5e5; color: #000;"
						type="password"
						class="peer block min-h-[auto] w-full rounded border-0 bg-transparent px-3 py-[0.32rem] leading-[2.15] outline-none transition-all duration-200 ease-linear focus:placeholder:opacity-100 data-[te-input-state-active]:placeholder:opacity-100 motion-reduce:transition-none dark:text-neutral-200 dark:placeholder:text-neutral-200 [&:not([data-te-input-placeholder-active])]:placeholder:opacity-0"
						id="exampleFormControlInput22"
						placeholder="Password"
					/>
				</div>

				<div class="mb-6 flex items-center justify-between">
					<!-- Remember me checkbox -->
					<div class="mb-[0.125rem] block min-h-[1.5rem] pl-[1.5rem]">
						<input
							class="relative float-left -ml-[1.5rem] mr-[6px] checked:border-green-500 mt-[0.15rem] h-[1.125rem] w-[1.125rem] appearance-none rounded-[0.25rem] border-[0.125rem] border-solid border-neutral-300 outline-none before:pointer-events-none before:absolute before:h-[0.875rem] before:w-[0.875rem] before:scale-0 before:rounded-full before:bg-transparent before:opacity-0 before:shadow-[0px_0px_0px_13px_transparent] before:content-[''] checked:border-primary checked:bg-green-500 checked:before:opacity-[0.16] checked:after:absolute checked:after:-mt-px checked:after:ml-[0.25rem] checked:after:block checked:after:h-[0.8125rem] checked:after:w-[0.375rem] checked:after:rotate-45 checked:after:border-[0.125rem] checked:after:border-l-0 checked:after:border-t-0 checked:after:border-solid checked:after:border-white checked:after:bg-transparent checked:after:content-[''] hover:cursor-pointer hover:before:opacity-[0.04] hover:before:shadow-[0px_0px_0px_13px_rgba(0,0,0,0.6)] focus:shadow-none focus:transition-[border-color_0.2s] focus:before:scale-100 focus:before:opacity-[0.12] focus:before:shadow-[0px_0px_0px_13px_rgba(0,0,0,0.6)] focus:before:transition-[box-shadow_0.2s,transform_0.2s] focus:after:absolute focus:after:z-[1] focus:after:block focus:after:h-[0.875rem] focus:after:w-[0.875rem] focus:after:rounded-[0.125rem] focus:after:content-[''] checked:focus:before:scale-100 checked:focus:before:shadow-[0px_0px_0px_13px_#07be73] checked:focus:before:transition-[box-shadow_0.2s,transform_0.2s] checked:focus:after:-mt-px checked:focus:after:ml-[0.25rem] checked:focus:after:h-[0.8125rem] checked:focus:after:w-[0.375rem] checked:focus:after:rotate-45 checked:focus:after:rounded-none checked:focus:after:border-[0.125rem] checked:focus:after:border-l-0 checked:focus:after:border-t-0 checked:focus:after:border-solid checked:focus:after:border-white checked:focus:after:bg-transparent dark:border-neutral-600 dark:checked:#07be73 dark:checked:#07be73 dark:focus:before:shadow-[0px_0px_0px_13px_#07be73] dark:checked:focus:before:shadow-[0px_0px_0px_13px_#3b71ca]"
							type="checkbox"
							value=""
							id="exampleCheck2"
						/>
						<label class="inline-block pl-[0.15rem] hover:cursor-pointer" for="exampleCheck2">
							Remember me
						</label>
					</div>

					<!--Forgot password link-->
					<a href="#!">Forgot password?</a>
				</div>

				<!-- Login button -->
				<div class="text-center lg:text-left">
					<button
						style="background-color: #07be73; color: #fff;"
						type="submit"
						id="login"
						class="inline-block rounded bg-primary px-7 pb-2.5 pt-3 text-sm font-medium uppercase leading-normal text-white shadow-[0_4px_9px_-4px_#3b71ca] transition duration-150 ease-in-out hover:bg-primary-600 hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:bg-primary-600 focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] focus:outline-none focus:ring-0 active:bg-primary-700 active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.3),0_4px_18px_0_rgba(59,113,202,0.2)] dark:shadow-[0_4px_9px_-4px_rgba(59,113,202,0.5)] dark:hover:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:focus:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)] dark:active:shadow-[0_8px_9px_-4px_rgba(59,113,202,0.2),0_4px_18px_0_rgba(59,113,202,0.1)]"
						data-te-ripple-init
						data-te-ripple-color="light"
					>
						Login
					</button>

					<!-- Register link -->
					<p class="mb-0 mt-2 pt-1 text-sm font-semibold">
						Don't have an account?
						<a
							style="color: #fe6e5f;"
							href="/register"
							class="text-danger transition duration-150 ease-in-out hover:text-danger-600 focus:text-danger-600 active:text-danger-700"
							>Register</a
						>
					</p>
				</div>
			</form>
		</div>
	</div>
</section>
