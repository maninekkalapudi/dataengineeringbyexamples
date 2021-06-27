# **HDFS Commands**

A typical Hadoop cluster is nothing but a group of linux machines and interacting with the cluster is very similar to that of a linux machine. In case if you don't have any idea about linux commands follow the explainer below every command.

This is part of my [blog post](https://duckduckgo.com) on Hadoop Distributed FileSystem or HDFS where I've explained about the internals. Now we'll understand about it through commands. To simplify each linux command like ls, mkdir, rm, rmdir and etc. will be prefixed with `hadoop fs` or `hdfs dfs`

Here, I'm using [ITVersity](https://labs.itversity.com/) for all the practicals.

## 1. Lists all the HDFS commands

        hadoop fs

The output in the below image shows all the possible commands we can use. Ex: ls, mkdir, rm, rmdir and etc.

![hadoop fs](./mdimages/hdfs_commands/hadoop_fs_op.jpg)

## 2. list all the files in the HDFS directory

1.      `hadoop fs -ls <hdfs_path>`

`ls` is a basic command in linux which lists all the files, directories in a given path. Breaking down the above command:

1. `hadoop fs` - Prefix to the actual command. This will let us know that it is a command for HDFS.

2. `-ls` - Actual command(linux command) which specifies what action to be performed.

3. `<hdfs_path>` - Directory in HDFS.

*Note:* The `ls` command will access the namespace (directory structure and hierarchy) directly from the NameNode.

**Output:**

![hadoop fs -ls](./mdimages/hdfs_commands/hadoop_fs_ls_op.jpg)

- Here `/` means home directory and `ls` command lists all the files in the home directory.

2.      hadoop fs -ls -t -r <hdfs_path>

This command has extra options `-t` and `-r`.

- `-t` - displays the results based on modified time. Files will be displayed with increasing order of their last modified time

- `-r` - displays the data in reverse order.

Both `-t` and `-r` along with `-ls` will display the files in the specified directory with lastest modified time first.

Below mentioned are some options we could use with `ls` to display the results in the way we need.

- `-S` option displays the files/directories according to the size. Largest file first

3.        hadoop fs -ls -S <hdfs_path>

![hadoop fs -ls -S](./mdimages/hdfs_commands/hadoop_fs_ls_S_op.jpg)

The column before the date column shows the size of the data in KBs. 

4.        hadoop fs -ls -S -h <hdfs_path>

`-h` option is used to display the size in human redable format(like KB, MB and GB)

![hadoop fs -ls -S -h](./mdimages/hdfs_commands/hadoop_fs_ls_S_h_op.jpg)

5.        hadoop fs -ls -R <hdfs_path>

`-R` option is used to recursively list all the files and directories in the given path we will use

## 3. To search any file in a given HDFS path

        hadoop fs -ls <hdfs_path> | grep <search_term>

- Here we're getting the list of contents from a path in HDFS using `ls` and using pipe `|` we're passing the result to `grep` command. `grep` command will try to match the `<search_term>` in the list of files and directories it receives from `ls` command.

![hadoop fs -ls <hdfs_path> | grep <search_term>](./mdimages/hdfs_commands/hadoop_fs_grep_op.jpg)

## 4. Create a directory in HDFS

        hadoop fs mkdir <dir_path>/directory_name

- `<dir_path>` should be an existing path

- To create an empty directory structure at a given path, we should use `-P` option as shown below:

        hadoop fs mkdir -P <dir_path>/directory1/directory2

- Here, both `directory1` and `directory2` are newly created as mentioned in the above command

## 5. Remove a file, empty directory and a non-empty directory in HDFS

- To remove a file from an HDFS path, we can use `-rm` command

        hadoop fs -rm <dir_path>/<file_name>

- To recursively remove the files in an HDFS directory, `-R` option should be passed along with `rm`

        hadoop fs -rm -R <dir_path>/directory1/

- To remove a directory along with its content, we can use `-rmdir` command as below

        hadoop fs -rmdir <dir_path>/directory1

## 6. Copying files from local machine to HDFS

step1: Create a file in local machine. We can also use the files the are already in the local machine.

        touch <local_path>/<local_file_name> 

step2: Create a directory in HDFS path

        hadoop fs -mkdir <hdfs_path>/<dir_name>

step3: Use `-copyFromLocal` or `-put` command to copy the file from local machine to HDFS

        hadoop fs -copyFromLocal <local_path>/<local_file_name> <hdfs_path>

                                (OR)

        hadoop fs -put <local_path>/<local_file_name> <hdfs_path>

- Copying directories from local machine to HDFS

case 1:

        hadoop fs -copyFromLocal <local_path>/local_directory <hdfs_path>

case 2:

        hadoop fs -copyFromLocal <local_path>/local_directory <hdfs_path>/directory1

## 7. Copying directories from hdfs to local

- To copy data from HDFS to local machine, we can use `-copyToLocal` or `-get` commands

        hadoop fs -copyToLocal <hdfs_path> <local_path>

                                (OR)

        hadoop fs -get <hdfs_path> <local_path>

## 8. To view contents of a file-->

- `-tail` command will give the last few lines of a file.

        hadoop fs -tail <hdfs_file_path>

- `-cat` will give all the contents of the file.

        hadoop fs -cat <hdfs_file_path> | more

- In the above command we are outputting the result of `-cat` command to `more` command using `|`. The `more` command will show first few lines of the file and rest of the file contents will be shown by pressing `return/enter` key.

## 9. Copy and Move files from one location to other in HDFS

- `-cp` command will be used to copy the files from one HDFS location to another.

        hadoop fs -cp <hdfs_path_source> <hdfs_path_destination>

*Note:* When we use the `-cp` command to copy the files, the data will be moved from one datanode to perform the copy operation. The NameNode will update the metadata for the files in the `<hdfs_path_destination>` location.

- `-mv` command will be used to move files from one location to another

        hadoop fs -mv <hdfs_path_source> <hdfs_path_destination>

*Note:* When we use the `-mv` command to move the files from `<hdfs_path_source>` to `<hdfs_path_destination>`, only the metadata in the NameNode will be updated for the files or directories. No data is moved between the data nodes

## 10. Check disk space of the HDFS cluster

- `-df` command will give the free space available in the cluster

        hadoop fs -df -h <hdfs_path>

- `-du` command will give the used space in the cluster

        hadoop fs -du -h <hdfs_path>

- `-du -s` command summarizes the data data used by all the files in the path

        hadoop fs -du -s -h <hdfs_path>

<!--- Change Replication factor -->

hadoop fs -Ddfs.replication=5 -put <local_path>/<file_name> <hdfs_path>

<!--- Get metadata in HDFS-->

hdfs fsck <hdfs_path> -files -blocks -locations
