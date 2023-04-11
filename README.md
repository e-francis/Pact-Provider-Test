# Pact Provider Test

## Introduction
Pact Provider Test is a project that enables contract testing for RESTful APIs using the Pact framework. Contract testing is a technique used in software development to ensure that the interactions between different systems or components are in accordance with agreed-upon contracts or specifications. The Pact framework provides a simple and effective way to write and execute contract tests for APIs.

This project provides a sample implementation of a provider (server) for contract testing using Pact. It allows you to define the expected interactions with the provider API and automatically generates the corresponding Pact contract files, which can be used by consumers (clients) to validate their interactions with the provider.

## Features
- Contract testing for RESTful APIs using the Pact framework.
- Easy setup and configuration for defining provider interactions and generating Pact contract files.
- Support for different programming languages and frameworks.
- Detailed logging and reporting for test results.

## Requirements
To use Pact Provider Test, you will need the following:

- A RESTful API provider that you want to test.
- A test framework or library for your programming language or framework of choice.
- Pact library for your programming language or framework (e.g., Pact-JVM, Pact-Ruby, Pact-JS, etc.).
- Pact Broker (optional) for publishing and managing your Pact contract files (e.g., Pactflow, Pact Broker API, etc.).

## Getting Started
To start using Pact Provider Test, follow these steps:

1. Clone the repository from GitHub: `git clone https://github.com/e-francis/Pact-Provider-Test.git`.
2. Install the dependencies required for your programming language or framework. Refer to the documentation of the Pact library for your chosen language or framework for installation instructions.
3. Configure the Pact Provider Test settings, such as the provider name, API endpoint, and Pact Broker details (if used). Update the configuration file according to your requirements.
4. Define the expected interactions with the provider API in the test files. These interactions will be used to generate the Pact contract files.
5. Execute the tests using your preferred test runner or framework. The tests will send requests to the provider API and verify the responses against the expected interactions.
6. Review the test results and generated Pact contract files. If the tests pass, the Pact contract files will be generated in the specified output directory. If the tests fail, investigate and fix the issues before re-running the tests.
7. Publish the generated Pact contract files to a Pact Broker (optional) for sharing with consumers (clients) of your API. This step is recommended if you have multiple consumers that need to validate their interactions with the provider.

## Configuration
Pact Provider Test provides a configuration file (`pact-provider-test.yml`) that you can update to configure various settings for your provider tests. The following configuration options are available:

- `provider_name`: The name of your provider API. This will be used as the provider name in the generated Pact contract files.
- `provider_base_url`: The base URL of your provider API. This is the URL that will be used by the tests to send requests to the provider.
- `output_dir`: The directory where the generated Pact contract files will be stored.
- `pact_broker`: (Optional) The details of the Pact Broker that you want to publish the generated Pact contract files to. This includes the URL of the Pact Broker and the authentication credentials (if required).
- `log_level`: The logging level for test execution. You can set it to `debug`, `info`, `warn`, or `error` depending on your desired level of verbosity.

## Writing Tests
Pact Provider Test uses your chosen test framework or library for writing the tests. You need to define the expected interactions with the provider API in your tests, which will
