<div class="bg-green-50">
	<div class="flex items-center justify-center flex-col h-[80vh] gap-10">
		<h1 class="text-4xl font-bold" style="padding-top: 3rem;">About us</h1>
			<div style="height: 1px; width:90%; background: gray;"></div>
			<article style="overflow: scroll;" class="markdown-body entry-content container-lg s-PalH6l0zoH1z" itemprop="text">
				<h1 tabindex="-1" dir="auto" class="s-PalH6l0zoH1z">
					<a
						id="user-content-mega-project---reshoprio"
						class="anchor s-PalH6l0zoH1z"
						aria-hidden="true"
						href="#mega-project---reshoprio"
						><svg
							class="octicon octicon-link s-PalH6l0zoH1z"
							viewBox="0 0 16 16"
							version="1.1"
							width="16"
							height="16"
							aria-hidden="true"
							><path
								d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"
								class="s-PalH6l0zoH1z"
							/></svg
						></a
					>
					Mega Project - reshoprio
				</h1>
				<p dir="auto" class="s-PalH6l0zoH1z">
					This is a prototype of an online marketplace. The system meets many of the functional
					requirements that was specified in the assignment.
				</p>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">
						A user can declare a product to sell and add information about it.
					</li>
					<li class="s-PalH6l0zoH1z">
						A user can search for products that are available on the marketplace.
					</li>
					<li class="s-PalH6l0zoH1z">
						A user can add products to a shopping cart and then confirm the cart as an order.
					</li>
					<li class="s-PalH6l0zoH1z">
						A user can register an interest in a particular product type.
					</li>
				</ul>
				<h2 tabindex="-1" dir="auto" class="s-PalH6l0zoH1z">
					<a
						id="user-content-architecture"
						class="anchor s-PalH6l0zoH1z"
						aria-hidden="true"
						href="#architecture"
						><svg
							class="octicon octicon-link s-PalH6l0zoH1z"
							viewBox="0 0 16 16"
							version="1.1"
							width="16"
							height="16"
							aria-hidden="true"
							><path
								d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"
								class="s-PalH6l0zoH1z"
							/></svg
						></a
					>
					Architecture
				</h2>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">
						<strong class="s-PalH6l0zoH1z">Microservices</strong>
						<ul dir="auto" class="s-PalH6l0zoH1z">
							<li class="s-PalH6l0zoH1z">CartsService</li>
							<li class="s-PalH6l0zoH1z">OrderService</li>
							<li class="s-PalH6l0zoH1z">ProductService</li>
							<li class="s-PalH6l0zoH1z">SearchService</li>
							<li class="s-PalH6l0zoH1z">UserService</li>
							<li class="s-PalH6l0zoH1z">AutchenticationService</li>
							<li class="s-PalH6l0zoH1z">Utils</li>
						</ul>
					</li>
					<li class="s-PalH6l0zoH1z">
						<strong class="s-PalH6l0zoH1z">Client-Server</strong>
						<ul dir="auto" class="s-PalH6l0zoH1z">
							<li class="s-PalH6l0zoH1z">ServerDiscovery</li>
							<li class="s-PalH6l0zoH1z">GatewayApplication</li>
						</ul>
					</li>
					<li class="s-PalH6l0zoH1z">
						<strong class="s-PalH6l0zoH1z">Publish-Subscribe</strong>
						<ul dir="auto" class="s-PalH6l0zoH1z">
							<li class="s-PalH6l0zoH1z">SubscribtionService</li>
							<li class="s-PalH6l0zoH1z">NotificationService</li>
						</ul>
					</li>
				</ul>
				<h2 tabindex="-1" dir="auto" class="s-PalH6l0zoH1z">
					<a
						id="user-content-technologies-used"
						class="anchor s-PalH6l0zoH1z"
						aria-hidden="true"
						href="#technologies-used"
						><svg
							class="octicon octicon-link s-PalH6l0zoH1z"
							viewBox="0 0 16 16"
							version="1.1"
							width="16"
							height="16"
							aria-hidden="true"
							><path
								d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"
								class="s-PalH6l0zoH1z"
							/></svg
						></a
					>
					Technologies Used
				</h2>
				<p dir="auto" class="s-PalH6l0zoH1z"><strong class="s-PalH6l0zoH1z">Front-End:</strong></p>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">SvelteKit &amp; Vite</li>
					<li class="s-PalH6l0zoH1z">TailwindCSS</li>
				</ul>
				<p dir="auto" class="s-PalH6l0zoH1z"><strong class="s-PalH6l0zoH1z">Back-End:</strong></p>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">
						Java Spring Boot
						<ul dir="auto" class="s-PalH6l0zoH1z">
							<li class="s-PalH6l0zoH1z">Eureka Server</li>
							<li class="s-PalH6l0zoH1z">Spring Cloud Gateway</li>
						</ul>
					</li>
					<li class="s-PalH6l0zoH1z">Firebase Real-Time Database</li>
				</ul>
				<h2 tabindex="-1" dir="auto" class="s-PalH6l0zoH1z">
					<a
						id="user-content-run-locally"
						class="anchor s-PalH6l0zoH1z"
						aria-hidden="true"
						href="#run-locally"
						><svg
							class="octicon octicon-link s-PalH6l0zoH1z"
							viewBox="0 0 16 16"
							version="1.1"
							width="16"
							height="16"
							aria-hidden="true"
							><path
								d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"
								class="s-PalH6l0zoH1z"
							/></svg
						></a
					>
					Run Locally
				</h2>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">
						Make sure you have
						<a
							href="https://www.oracle.com/java/technologies/downloads/#java17"
							rel="nofollow"
							class="s-PalH6l0zoH1z">Java 17</a
						>
						installed on your machine.
					</li>
					<li class="s-PalH6l0zoH1z">
						Make sure you have
						<a href="https://maven.apache.org/download.cgi" rel="nofollow" class="s-PalH6l0zoH1z"
							>Maven</a
						>
						installed on your machine.
					</li>
					<li class="s-PalH6l0zoH1z">
						Make sure you have
						<a href="https://nodejs.org/en/download" rel="nofollow" class="s-PalH6l0zoH1z"
							>Node.js</a
						>
						installed on your machine. (version 16 or later)
					</li>
					<li class="s-PalH6l0zoH1z">Clone the repository to your local machine.</li>
				</ul>
				<h3 tabindex="-1" dir="auto" class="s-PalH6l0zoH1z">
					<a
						id="user-content-back-end"
						class="anchor s-PalH6l0zoH1z"
						aria-hidden="true"
						href="#back-end"
						><svg
							class="octicon octicon-link s-PalH6l0zoH1z"
							viewBox="0 0 16 16"
							version="1.1"
							width="16"
							height="16"
							aria-hidden="true"
							><path
								d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"
								class="s-PalH6l0zoH1z"
							/></svg
						></a
					>
					Back-end
				</h3>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">Navigate to folder: back-end/mini-project</li>
					<li class="s-PalH6l0zoH1z">Open the folder in IntelliJ</li>
					<li class="s-PalH6l0zoH1z">
						Execute
						<a
							href="https://www.jetbrains.com/help/idea/work-with-maven-goals.html"
							rel="nofollow"
							class="s-PalH6l0zoH1z">Maven goals</a
						>
						:
						<ul dir="auto" class="s-PalH6l0zoH1z">
							<li class="s-PalH6l0zoH1z">mvn clean</li>
							<li class="s-PalH6l0zoH1z">mvn compile</li>
						</ul>
					</li>
					<li class="s-PalH6l0zoH1z">
						Run the back-end:
						<ul dir="auto" class="s-PalH6l0zoH1z">
							<li class="s-PalH6l0zoH1z">Start ServerDiscovery</li>
							<li class="s-PalH6l0zoH1z">Start GatewayApplication</li>
							<li class="s-PalH6l0zoH1z">Start the remaining services</li>
						</ul>
					</li>
				</ul>
				<h3 tabindex="-1" dir="auto" class="s-PalH6l0zoH1z">
					<a
						id="user-content-front-end"
						class="anchor s-PalH6l0zoH1z"
						aria-hidden="true"
						href="#front-end"
						><svg
							class="octicon octicon-link s-PalH6l0zoH1z"
							viewBox="0 0 16 16"
							version="1.1"
							width="16"
							height="16"
							aria-hidden="true"
							><path
								d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"
								class="s-PalH6l0zoH1z"
							/></svg
						></a
					>
					Front-End
				</h3>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">Navigate to folder: front-end/src</li>
					<li class="s-PalH6l0zoH1z">Install the dependencies from your terminal:</li>
				</ul>
				<div
					class="highlight highlight-source-shell notranslate position-relative overflow-auto s-PalH6l0zoH1z"
					dir="auto"
				>
					<pre class="s-PalH6l0zoH1z" style="position: relative;">		  npm install
	  <div class="open_grepper_editor" title="Edit &amp; Save To Grepper" /></pre>
					<div class="zeroclipboard-container s-PalH6l0zoH1z">
						<clipboard-copy
							aria-label="Copy"
							class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 tooltipped-no-delay d-flex flex-justify-center flex-items-center s-PalH6l0zoH1z"
							data-copy-feedback="Copied!"
							data-tooltip-direction="w"
							value="npm install"
							tabindex="0"
							role="button"
							><svg
								aria-hidden="true"
								height="16"
								viewBox="0 0 16 16"
								version="1.1"
								width="16"
								data-view-component="true"
								class="octicon octicon-copy js-clipboard-copy-icon s-PalH6l0zoH1z"
								><path
									d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"
									class="s-PalH6l0zoH1z"
								/><path
									d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"
									class="s-PalH6l0zoH1z"
								/></svg
							>
							<svg
								aria-hidden="true"
								height="16"
								viewBox="0 0 16 16"
								version="1.1"
								width="16"
								data-view-component="true"
								class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none s-PalH6l0zoH1z"
								><path
									d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"
									class="s-PalH6l0zoH1z"
								/></svg
							></clipboard-copy
						>
					</div>
				</div>
				<ul dir="auto" class="s-PalH6l0zoH1z"><li class="s-PalH6l0zoH1z">Run the front-end</li></ul>
				<div
					class="highlight highlight-source-shell notranslate position-relative overflow-auto s-PalH6l0zoH1z"
					dir="auto"
				>
					<pre class="s-PalH6l0zoH1z" style="position: relative;">		  npm run dev
	  <div class="open_grepper_editor" title="Edit &amp; Save To Grepper" /></pre>
					<div class="zeroclipboard-container s-PalH6l0zoH1z">
						<clipboard-copy
							aria-label="Copy"
							class="ClipboardButton btn btn-invisible js-clipboard-copy m-2 p-0 tooltipped-no-delay d-flex flex-justify-center flex-items-center s-PalH6l0zoH1z"
							data-copy-feedback="Copied!"
							data-tooltip-direction="w"
							value="npm run dev"
							tabindex="0"
							role="button"
							><svg
								aria-hidden="true"
								height="16"
								viewBox="0 0 16 16"
								version="1.1"
								width="16"
								data-view-component="true"
								class="octicon octicon-copy js-clipboard-copy-icon s-PalH6l0zoH1z"
								><path
									d="M0 6.75C0 5.784.784 5 1.75 5h1.5a.75.75 0 0 1 0 1.5h-1.5a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-1.5a.75.75 0 0 1 1.5 0v1.5A1.75 1.75 0 0 1 9.25 16h-7.5A1.75 1.75 0 0 1 0 14.25Z"
									class="s-PalH6l0zoH1z"
								/><path
									d="M5 1.75C5 .784 5.784 0 6.75 0h7.5C15.216 0 16 .784 16 1.75v7.5A1.75 1.75 0 0 1 14.25 11h-7.5A1.75 1.75 0 0 1 5 9.25Zm1.75-.25a.25.25 0 0 0-.25.25v7.5c0 .138.112.25.25.25h7.5a.25.25 0 0 0 .25-.25v-7.5a.25.25 0 0 0-.25-.25Z"
									class="s-PalH6l0zoH1z"
								/></svg
							>
							<svg
								aria-hidden="true"
								height="16"
								viewBox="0 0 16 16"
								version="1.1"
								width="16"
								data-view-component="true"
								class="octicon octicon-check js-clipboard-check-icon color-fg-success d-none s-PalH6l0zoH1z"
								><path
									d="M13.78 4.22a.75.75 0 0 1 0 1.06l-7.25 7.25a.75.75 0 0 1-1.06 0L2.22 9.28a.751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018L6 10.94l6.72-6.72a.75.75 0 0 1 1.06 0Z"
									class="s-PalH6l0zoH1z"
								/></svg
							></clipboard-copy
						>
					</div>
				</div>
				<h2 tabindex="-1" dir="auto" class="s-PalH6l0zoH1z">
					<a
						id="user-content-authors"
						class="anchor s-PalH6l0zoH1z"
						aria-hidden="true"
						href="#authors"
						><svg
							class="octicon octicon-link s-PalH6l0zoH1z"
							viewBox="0 0 16 16"
							version="1.1"
							width="16"
							height="16"
							aria-hidden="true"
							><path
								d="m7.775 3.275 1.25-1.25a3.5 3.5 0 1 1 4.95 4.95l-2.5 2.5a3.5 3.5 0 0 1-4.95 0 .751.751 0 0 1 .018-1.042.751.751 0 0 1 1.042-.018 1.998 1.998 0 0 0 2.83 0l2.5-2.5a2.002 2.002 0 0 0-2.83-2.83l-1.25 1.25a.751.751 0 0 1-1.042-.018.751.751 0 0 1-.018-1.042Zm-4.69 9.64a1.998 1.998 0 0 0 2.83 0l1.25-1.25a.751.751 0 0 1 1.042.018.751.751 0 0 1 .018 1.042l-1.25 1.25a3.5 3.5 0 1 1-4.95-4.95l2.5-2.5a3.5 3.5 0 0 1 4.95 0 .751.751 0 0 1-.018 1.042.751.751 0 0 1-1.042.018 1.998 1.998 0 0 0-2.83 0l-2.5 2.5a1.998 1.998 0 0 0 0 2.83Z"
								class="s-PalH6l0zoH1z"
							/></svg
						></a
					>
					Authors
				</h2>
				<ul dir="auto" class="s-PalH6l0zoH1z">
					<li class="s-PalH6l0zoH1z">
						Habib Mohammadi -
						<a href="https://github.com/khabbib" class="s-PalH6l0zoH1z">@khabbib</a>
					</li>
					<li class="s-PalH6l0zoH1z">
						Kasper Kadestål -
						<a href="https://github.com/Kasperkadestal" class="s-PalH6l0zoH1z">@Kasperkadestal</a>
					</li>
					<li class="s-PalH6l0zoH1z">
						Jakob Hagman -
						<a href="https://github.com/JSGHagman" class="s-PalH6l0zoH1z">@JSGHagman</a>
					</li>
					<li class="s-PalH6l0zoH1z">
						Sossio Giorgelli -
						<a href="https://github.com/SossioG" class="s-PalH6l0zoH1z">@SossioG</a>
					</li>
					<li class="s-PalH6l0zoH1z">
						Philip Holmqvist -
						<a href="https://github.com/PhilipHolmqvist" class="s-PalH6l0zoH1z">@PhilipHolmqvist</a>
					</li>
				</ul>
			</article>
		</div>
</div>

<style>
	@media all {
		section {
			display: block;
		}
	}

	@media all {
		[tabindex='0']:focus {
			outline: none;
		}
	}

	.cTsUqU {
		border-bottom-left-radius: 6px;
		border-bottom-right-radius: 6px;
		padding: 32px;
		min-width: 0px;
	}

	@media all {
		[data-color-mode='light'][data-light-theme*='dark'] :selection,
		[data-color-mode='dark'][data-dark-theme*='dark'] :selection {
			background-color: var(--color-accent-muted);
		}

		article {
			display: block;
		}

		.container-lg {
			max-width: 1012px;
			margin-right: auto;
			margin-left: auto;
		}

		.markdown-body {
			font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Noto Sans', Helvetica, Arial,
				sans-serif, 'Apple Color Emoji', 'Segoe UI Emoji';
			font-size: 16px;
			line-height: 1.5;
			word-wrap: break-word;
		}

		.markdown-body:before {
			display: table;
			content: '';
		}

		.markdown-body:after {
			display: table;
			clear: both;
			content: '';
		}

		h1 {
			font-size: var(--h1-size, 32px);
			margin: 0.67em 0;
			margin-top: 0;
			margin-bottom: 0;
			font-weight: var(--base-text-weight-semibold, 600);
		}

		.markdown-body h1 {
			margin-top: 24px;
			margin-bottom: 16px;
			font-weight: var(--base-text-weight-semibold, 600);
			line-height: 1.25;
			padding-bottom: 0.3em;
			font-size: 2em;
			border-bottom: 1px solid var(--color-border-muted);
		}

		.markdown-body > :first-child {
			margin-top: 0 !important;
		}

		p {
			margin-top: 0;
			margin-bottom: 10px;
		}

		.markdown-body p {
			margin-top: 0;
			margin-bottom: 16px;
		}

		ul {
			padding-left: 0;
			margin-top: 0;
			margin-bottom: 0;
		}

		.markdown-body ul {
			margin-top: 0;
			margin-bottom: 16px;
			padding-left: 2em;
		}

		h2 {
			margin-top: 0;
			margin-bottom: 0;
			font-size: var(--h2-size, 24px);
			font-weight: var(--base-text-weight-semibold, 600);
		}

		.markdown-body h2 {
			margin-top: 24px;
			margin-bottom: 16px;
			font-weight: var(--base-text-weight-semibold, 600);
			line-height: 1.25;
			padding-bottom: 0.3em;
			font-size: 1.5em;
			border-bottom: 1px solid var(--color-border-muted);
		}

		h3 {
			margin-top: 0;
			margin-bottom: 0;
			font-size: var(--h3-size, 20px);
			font-weight: var(--base-text-weight-semibold, 600);
		}

		.markdown-body h3 {
			margin-top: 24px;
			margin-bottom: 16px;
			font-weight: var(--base-text-weight-semibold, 600);
			line-height: 1.25;
			font-size: 1.25em;
		}

		.position-relative {
			position: relative !important;
		}

		.overflow-auto {
			overflow: auto !important;
		}

		.markdown-body .highlight {
			margin-bottom: 16px;
		}

		.js-snippet-clipboard-copy-unpositioned .markdown-body .highlight {
			display: flex;
			justify-content: space-between;
			margin-bottom: 16px;
			background-color: var(--color-canvas-subtle);
		}

		.markdown-body > :last-child {
			margin-bottom: 0 !important;
		}

		a {
			background-color: transparent;
			color: var(--color-accent-fg);
			text-decoration: none;
		}

		.markdown-body .anchor {
			float: left;
			padding-right: 4px;
			margin-left: -20px;
			line-height: 1;
		}

		a:hover {
			text-decoration: underline;
		}

		.markdown-body h1:hover .anchor {
			text-decoration: none;
		}

		.markdown-body li + li {
			margin-top: 0.25em;
		}

		.markdown-body h2:hover .anchor {
			text-decoration: none;
		}

		strong {
			font-weight: var(--base-text-weight-semibold, 600);
		}

		.markdown-body h3:hover .anchor {
			text-decoration: none;
		}

		pre {
			font-family: ui-monospace, SFMono-Regular, SF Mono, Menlo, Consolas, Liberation Mono,
				monospace;
			font-size: 12px;
			margin-top: 0;
			margin-bottom: 0;
		}

		.markdown-body pre {
			margin-top: 0;
			margin-bottom: 16px;
			word-wrap: normal;
		}

		.markdown-body .highlight pre {
			margin-bottom: 0;
			word-break: normal;
		}

		.markdown-body .highlight pre,
		.markdown-body pre {
			padding: 16px;
			overflow: auto;
			font-size: 85%;
			line-height: 1.45;
			color: var(--color-fg-default);
			background-color: var(--color-canvas-subtle);
			border-radius: 6px;
		}

		.js-snippet-clipboard-copy-unpositioned .markdown-body .highlight pre {
			margin-bottom: 0;
		}

		.markdown-body .highlight .zeroclipboard-container {
			display: none;
			animation: fade-out 200ms both;
		}

		.js-snippet-clipboard-copy-unpositioned .markdown-body .highlight .zeroclipboard-container {
			display: block;
			animation: none;
		}

		.markdown-body .highlight:hover .zeroclipboard-container {
			display: block;
			animation: fade-in 200ms both;
		}

		.octicon {
			display: inline-block;
			vertical-align: text-bottom;
			overflow: visible !important;
			fill: currentColor;
		}

		svg:not(:root) {
			overflow: hidden;
		}

		.markdown-body h1 .octicon-link {
			color: var(--color-fg-default);
			vertical-align: middle;
			visibility: hidden;
		}

		.markdown-body h2 .octicon-link {
			color: var(--color-fg-default);
			vertical-align: middle;
			visibility: hidden;
		}

		.markdown-body ul ul {
			margin-top: 0;
			margin-bottom: 0;
		}

		.markdown-body h3 .octicon-link {
			color: var(--color-fg-default);
			vertical-align: middle;
			visibility: hidden;
		}

		.btn {
			display: inline-block;
			position: relative;
			padding: 5px 16px;
			font-size: 14px;
			font-weight: var(--base-text-weight-medium, 500);
			line-height: 20px;
			white-space: nowrap;
			vertical-align: middle;
			cursor: pointer;
			-webkit-user-select: none;
			user-select: none;
			border: 1px solid;
			border-radius: 6px;
			-webkit-appearance: none;
			appearance: none;
			color: var(--color-btn-text);
			background-color: var(--color-btn-bg);
			border-color: var(--color-btn-border);
			box-shadow: var(--color-btn-shadow), var(--color-btn-inset-shadow);
			transition: 80ms cubic-bezier(0.33, 1, 0.68, 1);
			transition-property: color, background-color, box-shadow, border-color;
		}

		.btn-invisible {
			color: var(--color-accent-fg);
			background-color: transparent;
			border: 0;
			border-radius: 6px;
			box-shadow: none;
		}

		.flex-justify-center {
			justify-content: center !important;
		}

		.flex-items-center {
			align-items: center !important;
		}

		.m-2 {
			margin: var(--base-size-8, 8px) !important;
		}

		.p-0 {
			padding: 0 !important;
		}

		.d-flex {
			display: flex !important;
		}

		.ClipboardButton {
			position: relative;
		}

		.js-snippet-clipboard-copy-unpositioned
			.markdown-body
			.highlight
			.zeroclipboard-container
			clipboard-copy {
			width: var(--control-small-size, 28px);
			height: var(--control-small-size, 28px);
		}

		.btn .octicon {
			margin-right: 4px;
			color: var(--color-fg-muted);
			vertical-align: text-bottom;
		}

		.color-fg-success {
			color: var(--color-success-fg) !important;
		}

		.d-none {
			display: none !important;
		}
	}
</style>
