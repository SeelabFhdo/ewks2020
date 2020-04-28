# Eclipse Modeling Framework and UML Examples

This repository contains usage examples of tools from or based on the Eclipse Modeling Framework (EMF) [1], and UML examples. The usage examples show

- the implementation of an abstract and concrete syntax for a textual language for modeling simple data structures (*used tools:* Xcore and Xtext [2,3]).
- models that represent different views on a microservice architecture and which are expressed with the Language Ecosystem for Modeling Microservice Architectures (LEMMA) [4].

To play around with the provided examples, follow these steps:

1. Download one of the predefined Eclipse packages depending on your OS:
   * Linux: [Link](https://www.ilias.fh-dortmund.de/ilias/goto_ilias-fhdo_file_822607_download.html)
   * macOS: [Link](https://www.ilias.fh-dortmund.de/ilias/goto_ilias-fhdo_file_822655_download.html)
   * Windows: [Link](https://www.ilias.fh-dortmund.de/ilias/goto_ilias-fhdo_file_822609_download.html)

2. Clone/Download this repository to your harddrive. 
3. Run the ``eclipse`` executable in the package you downloaded in step 1, create a workspace as requested by the IDE, and import the projects you cloned/downloaded in step 2. Projects can be imported in Eclipse by hitting ``File > Open Projects from File System...``, then choosing the parent folder of the cloned/downloaded projects as ``Import source``, and after the projects were loaded hitting ``Finish``.

Now that you have imported all projects into your workspace, you can try out the usage examples. The execution of the examples is technology-specific.

## Running the Xcore and Xtext Usage Examples

To try out the Xcore and Xtext examples, you have to do the following:
<ol type="a">
<li>
  Right click on the project <code>de.fhdo.ewks.ml_example.xtext</code> which you imported into your workspace in step 3 above and from the context menu choose <code>Run As > Eclipse Application</code>. A new runtime Eclipse instance is opened.
</li>

<li>
  In the runtime Eclipse instance switch to the workbench and create a new <code>Java Project</code> entitled, e.g., <code>Test</code>.
</li>

<li>
  In the new <code>Test</code> project create a file with the extension <code>.struct</code> and the name <code>MyStructure</code>, i.e., the file's full name is <code>MyStructure.struct</code>. Confirm any subsequent dialogs with <code>Yes</code>.
</li>

<li>
  In the open editor showing the empty file <code>MyStructure.struct</code>, enter the following piece of code that conforms to the syntax of the Data Structure Modeling Language:
<pre>
context Accounting {
  structure ParkingSpace {
    string name,
    string description,
    boolean isOpen,
    double longitude,
    double latitude
  }
}
</pre>
</ol>

The editor highlights the code according to what you have seen in the MDE lecture.

## Running the LEMMA Examples

To try out the LEMMA examples, you have to do the following:
<ol type="a">
<li>
  Open the project <code>LEMMA-examples</code> which you imported into your workspace in step 3 above.
</li>

<li>
  Within the project you will find different folders. 
  <ul>
    <li>The <code>domain models</code> folder comprises the domain models <code>Banking.data</code> and <code>Student.data</code> expressed in LEMMA's Domain Data Modeling Language.</li>
    <li>The <code>microservices</code> folder comprises the service models <code>Banking.services</code> and <code>Student.services</code> expressed in LEMMA's Service Modeling Language.</li>
    <li>The <code>operation</code> folder comprises the operation model <code>Architecture.operation</code> expressed in LEMMA's Operation Modeling Language.</li>
    <li>The <code>technology</code> folder comprises the Java technology model (file <code>java.technology</code>) used throughout the lectures. You are invited to explore and play around with it, in case you are curious.</li>
    </ol>
  You can double click on each of the mentioned files to open the editor that shows the contained model according to the syntax of the respective modeling language and play around with the models leveraging the editor.

## References
[1] [https://wiki.eclipse.org/EMF](https://wiki.eclipse.org/EMF)  
[2] [https://wiki.eclipse.org/Xcore](https://wiki.eclipse.org/Xcore)  
[3] [https://www.eclipse.org/Xtext](https://www.eclipse.org/Xtext)  
[4] [https://github.com/SeelabFhdo/lemma](https://github.com/SeelabFhdo/lemma)
