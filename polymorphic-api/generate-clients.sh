#!/bin/bash

# Configuration
API_SPEC_FILE="openapi-payments.yaml"
OUTPUT_DIR="./generated-clients"

# Check if OpenAPI spec file exists
if [ ! -f "$API_SPEC_FILE" ]; then
    echo "Error: OpenAPI specification file '$API_SPEC_FILE' not found!"
    exit 1
fi

# Create output directory
mkdir -p $OUTPUT_DIR

# Function to generate client code
generate_client() {
    local language=$1
    local generator=$2
    local output_path=$3
    local additional_options=$4

    echo "Generating $language client..."

    docker run --rm \
        -v ${PWD}:/local \
        openapitools/openapi-generator-cli generate \
        -i /local/$API_SPEC_FILE \
        -g $generator \
        -o /local/$output_path \
        $additional_options

    # Set proper permissions for the generated files
    chmod -R a+rw $output_path

    echo "$language client generated at $output_path"
}

# Clean previous generated clients
echo "Cleaning previous generated clients..."
rm -rf $OUTPUT_DIR/*

# Generate Java client
generate_client "Java" "java" \
    "$OUTPUT_DIR/java-client" \
    "--api-package com.example.payments.client.api \
     --model-package com.example.payments.client.model \
     --invoker-package com.example.payments.client.invoker \
     --group-id com.example \
     --artifact-id payments-client \
     --artifact-version 1.0.0"

# Generate Kotlin Multiplatform client
generate_client "Kotlin Multiplatform" "kotlin" \
    "$OUTPUT_DIR/kotlin-multiplatform-client" \
    "--package-name com.example.payments.client \
     --library multiplatform"

# Generate additional clients if needed
# generate_client "Python" "python" \
#     "$OUTPUT_DIR/python-client" \
#     "--package-name payments_client"

# generate_client "TypeScript" "typescript-axios" \
#     "$OUTPUT_DIR/typescript-client" \
#     "--npm-name payments-client --npm-version 1.0.0"

echo "All clients generated successfully in the $OUTPUT_DIR directory!"
echo "Generated clients:"
ls -la $OUTPUT_DIR/